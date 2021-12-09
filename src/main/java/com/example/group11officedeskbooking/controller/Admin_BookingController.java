package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.DTO.DeskDTO;
import com.example.group11officedeskbooking.DTO.LotteryDTO;
import com.example.group11officedeskbooking.DateFormatter;
import com.example.group11officedeskbooking.repository.*;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

        //Find winners
        for(int i = 0; i < numWinners; i++){
            int randomIndex = rand.nextInt(lotteryContestants.size());
            //Do not add admin (user_id = 1)
            while(lotteryContestants.get(randomIndex).getUser_id() == 1){
                randomIndex = rand.nextInt(lotteryContestants.size());
            }
            lotteryWinners.add(lotteryContestants.get(randomIndex));
            lotteryContestants.remove(randomIndex);
            userRepo.addBooking(lotteryWinners.get(i).getUser_id(), lotteryWinners.get(i).getDate(), desksInLocation.get(i).getDesk_id());
        }
        userRepo.resolveLottery(inputDate, inputLocation);
        mav.addObject("lotteryWinners", lotteryWinners);
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
        mav.addObject("users", userRepo.getAllUsers());
        mav.addObject("locations", userRepo.getAllLocations());
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
        //Add aesthetic date
        mav.addObject("searchDate", stringDate);
        //Add original search date format
        mav.addObject("inputDate", searchDate);
        return mav;

    }
}
