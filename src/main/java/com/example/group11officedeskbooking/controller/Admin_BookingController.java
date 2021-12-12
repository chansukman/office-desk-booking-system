package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.DTO.Admin_BookingDTO;
import com.example.group11officedeskbooking.DTO.DeskDTO;
import com.example.group11officedeskbooking.DTO.LotteryDTO;
import com.example.group11officedeskbooking.DTO.UserDTO;
import com.example.group11officedeskbooking.DateFormatter;
import com.example.group11officedeskbooking.repository.*;
import org.apache.catalina.User;
import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.internet.MimeMessage;
import java.util.*;

import java.security.PublicKey;
import java.util.Optional;

import static java.lang.Math.max;
import static java.lang.Math.min;

@RestController
public class Admin_BookingController {

    private final Admin_BookingRepository admin_bookingRepository;
    private UserBookingRepository userRepo;
    private MapRepository mapRepo;
    private DeskRepository deskRepo;

    @Autowired
    public Admin_BookingController(Admin_BookingRepository admin_bookingRepository, UserBookingRepository userRepo, MapRepository mapRepo, DeskRepository deskRepo) {
        this.admin_bookingRepository = admin_bookingRepository;
        this.userRepo = userRepo;
        this.mapRepo = mapRepo;
        this.deskRepo = deskRepo;
    }

    @RequestMapping(path = "admin/bookings", method = RequestMethod.GET)
    public ModelAndView fetchAllRecords(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("adminBookingList", admin_bookingRepository.findAll());
        mav.setViewName("Admin_AllBookings");
        return mav;
    }

    @RequestMapping(path = "/admin/lottery")
    public ModelAndView adminLottery(ModelAndView mav){
        List<LotteryDTO> lotteryDays = admin_bookingRepository.getAllLotteryDays();
        for(LotteryDTO lotteryDTO: lotteryDays){
            lotteryDTO.setNumUsers(userRepo.checkNumberInLottery(lotteryDTO.getDate(), lotteryDTO.getLocation()));
        }
        mav.addObject("lotteryDays", lotteryDays);
        mav.setViewName("Admin_Lottery");
        return mav;
    }

    @RequestMapping(path = "/admin/lottery/{location}/{date}")
    public ModelAndView resolveLottery(@PathVariable Optional<String> location, @PathVariable Optional<String> date){
        ModelAndView mav = new ModelAndView();

        //Initialise required variables
        String inputLocation = location.get();
        String inputDate = date.get();
        List<LotteryDTO> lotteryContestants = userRepo.getAllUsersInLottery(inputDate, inputLocation);
        Random rand = new Random();
        int numWinners = min(userRepo.checkNumberInLocation(inputLocation), lotteryContestants.size() - 1);
        List<LotteryDTO> lotteryWinners = new ArrayList<LotteryDTO>();
        List<DeskDTO> desksInLocation = userRepo.getAllDeskIdInLocation(inputLocation);
        List<String> winnerList = new ArrayList<String>();

        //Find winners
        for(int i = 0; i < numWinners; i++){
            int randomIndex = rand.nextInt(lotteryContestants.size());
            //Do not add admin (user_id = 1)
            while(lotteryContestants.get(randomIndex).getUser_id() == 1){
                randomIndex = rand.nextInt(lotteryContestants.size());
            }
            lotteryWinners.add(lotteryContestants.get(randomIndex));
            winnerList.add(userRepo.findUserByUserID(lotteryWinners.get(i).getUser_id()).getFirstNameLastNameUserId());
            lotteryContestants.remove(randomIndex);
            userRepo.addBooking(lotteryWinners.get(i).getUser_id(), lotteryWinners.get(i).getDate(), desksInLocation.get(i).getDesk_id());
        }
        userRepo.resolveLottery(inputDate, inputLocation);
        mav.addObject("lotteryWinners", winnerList);
        mav.addObject("resolvedLottery", lotteryWinners);
        mav.setViewName("forward:/admin/lottery");
        return mav;
    }

    @RequestMapping(path = "/lotteryCreation", method = RequestMethod.GET)
    public ModelAndView createLotteryDay(@RequestParam(value="date", defaultValue = "null") String searchDate,
                                         @RequestParam(value="location", defaultValue = "null") String deskLocation){
        ModelAndView mav = new ModelAndView();
        ArrayList<String> lotteryInfo = new ArrayList<String>();
        lotteryInfo.add(searchDate);
        lotteryInfo.add(deskLocation);
        if(!userRepo.checkUserInLottery(searchDate, deskLocation, 1)){
            if(userRepo.addUserToLottery(searchDate, deskLocation, 1)){
                mav.addObject("success", lotteryInfo);
            }
        }
        else if(userRepo.checkUserInLottery(searchDate, deskLocation, 1)){
            mav.addObject("preExisting", lotteryInfo);
        }
        mav.setViewName("redirect:/admin/lottery");
        return mav;
    }

    // Deleting All Bookings

    @RequestMapping(path = "admin/bookings/delete/{booking_id}")
    public ModelAndView deleteBooking(@PathVariable Optional<String> booking_id) {
        int id = Integer.parseInt(booking_id.get());
        ModelAndView mav = new ModelAndView();

        Admin_BookingDTO adminDto = admin_bookingRepository.findById(id);
        UserDTO userDTO  = userRepo.findUserByUserID(adminDto.getUser_user_id());

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("testercardiff123@gmail.com");
        mailSender.setPassword("Tester@cardiff123");

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            DateFormatter prettyDate = new DateFormatter();

            if (userDTO.getEmail() != null){
                helper.setTo(userDTO.getEmail());
                helper.setSubject("Booking Cancelled!");
                helper.setText("Hello " + userDTO.getFirst_name() + ",\nWe just wanted to let you know that your booking for "
                        + prettyDate.formatDate(adminDto.getBooking_date())
                        + " on desk " + adminDto.getDesk_number() + " in " + adminDto.getDesk_location() +  " has been cancelled for some reason. \n" +
                        "Please login to " + " http://localhost:8080/userlogin " + " to book a new one." +
                        "\n\nRegards," +
                        "\nADMS Team");

                mailSender.setJavaMailProperties(props);
                mailSender.send(message);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        admin_bookingRepository.deleteById(id);
        mav.addObject("adminBookingList", admin_bookingRepository.findAll());
        mav.setViewName("Admin_AllBookings");
        return mav;
    }

    @RequestMapping(path = "/admin/createBooking")
    public ModelAndView Admin_CreateBooking(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("users", userRepo.getAllUsers());
        mav.addObject("locations", userRepo.getAllLocations());
        mav.setViewName("Admin_CreateBooking");
        return mav;
    }

    @RequestMapping(path = "/admin/createBooking/search", method = RequestMethod.GET)
    public ModelAndView adminSearchDesk(@RequestParam(value="date", defaultValue = "null") String searchDate,
                                        @RequestParam(value="location", defaultValue = "null") String deskLocation,
                                        @RequestParam(value="user-input", defaultValue = "null") String userID){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Admin_Createbooking");
        List<UserDTO> userList = userRepo.getAllUsers();
        mav.addObject("users", userList);
        mav.addObject("locations", userRepo.getAllLocations());
        String userNameAndId  = new String();
        //Get username
        for(UserDTO user: userList){
            if(user.getUser_id() == Integer.parseInt(userID)){
                userNameAndId = user.getFirstNameLastNameUserId();
                break;
            }
        }
        //Validation
        if(searchDate.equals("null") || deskLocation.equals("null") || userID.equals("null")){
            return mav;
        }

        //Convert date string format
        DateFormatter prettyDate = new DateFormatter();
        String stringDate = prettyDate.formatDate(searchDate);

        //Check if lottery day
        if(userRepo.checkLotteryDay(searchDate, deskLocation)){
            mav.addObject("lotteryDay", stringDate);
            mav.addObject("inputDate", searchDate);
            mav.addObject("userId",userID);
            mav.addObject("location", deskLocation);
            mav.addObject("userNameID", userNameAndId);
            return mav;
        }

        //Check if user already has a desk that day
        if(userRepo.checkIfUserHasBooking(searchDate, Integer.parseInt(userID))){
            mav.addObject("doubleBooking", stringDate);
            return mav;
        }

        //Check if weekend
        if(stringDate.charAt(0) == 'S'){
            mav.addObject("unavailable", "Sorry, desks are not bookable at the weekend");
            return mav;
        }



        //Add map and desk to mav
        mav.addObject("map", mapRepo.searchMap(deskLocation));
        mav.addObject("deskList", deskRepo.searchAvailableDesksByDate(searchDate, deskLocation));
        mav.addObject("location", deskLocation);
        mav.addObject("userId",userID);
        mav.addObject("userNameID", userNameAndId);
        //Add aesthetic date
        mav.addObject("searchDate", stringDate);
        //Add original search date format
        mav.addObject("inputDate", searchDate);
        return mav;

    }
}
