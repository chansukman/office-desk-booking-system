package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.DTO.DeskDTO;
import com.example.group11officedeskbooking.DTO.LotteryDTO;
import com.example.group11officedeskbooking.repository.Admin_BookingRepository;
import com.example.group11officedeskbooking.repository.UserBookingRepository;
import com.example.group11officedeskbooking.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static java.lang.Math.max;

@RestController
public class Admin_BookingController {

    private final Admin_BookingRepository admin_bookingRepository;
    private UserBookingRepository userRepo;

    @Autowired
    public Admin_BookingController(Admin_BookingRepository admin_bookingRepository, UserBookingRepository userRepo) {
        this.admin_bookingRepository = admin_bookingRepository;
        this.userRepo = userRepo;
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
        int numWinners = max(userRepo.checkNumberInLocation(inputLocation), lotteryContestants.size() - 1);
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
            System.out.println("Winner = " + lotteryWinners.get(i));
        }
        mav.addObject(lotteryWinners);
        mav.setViewName("redirect:/admin/lottery");
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

}
