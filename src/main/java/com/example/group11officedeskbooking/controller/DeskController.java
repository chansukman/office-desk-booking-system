package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.DTO.UserDTO;
import com.example.group11officedeskbooking.DateFormatter;
import com.example.group11officedeskbooking.repository.DeskRepository;
import com.example.group11officedeskbooking.repository.MapRepository;
import com.example.group11officedeskbooking.repository.UserBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class DeskController {

    private DeskRepository deskRepo;
    private MapRepository mapRepo;
    private UserBookingRepository userRepo;


    @Autowired
    public DeskController(DeskRepository newRepo, MapRepository mapRepo, UserBookingRepository userRepo){
        this.deskRepo = newRepo;
        this.mapRepo = mapRepo;
        this.userRepo = userRepo;
    }

    @RequestMapping(path = "/searchDate", method = RequestMethod.GET)
    public ModelAndView searchDate(@CookieValue(value = "userId",defaultValue = "null") String userId, @RequestParam(value="date", defaultValue = "null") String searchDate,
                                   @RequestParam(value="location", defaultValue = "null") String deskLocation){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("bookings");
        mav.addObject("locations", userRepo.getAllLocations());
        //Validation
        if(searchDate.equals("null") || deskLocation.equals("null")){
            return mav;
        }

        //Convert date string format
        DateFormatter prettyDate = new DateFormatter();
        String stringDate = prettyDate.formatDate(searchDate);

        //Check if lottery day
        if(userRepo.checkLotteryDay(searchDate, deskLocation)){
            mav.addObject("lotteryDay", stringDate);
            mav.addObject("inputDate", searchDate);
            mav.addObject("userId",userId);
            mav.addObject("location", deskLocation);
            return mav;
        }

        //Check if user already has a desk that day
        if(userRepo.checkIfUserHasBooking(searchDate, Integer.parseInt(userId))){
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
        mav.addObject("locations", userRepo.getAllLocations());
        mav.addObject("userId",userId);
        //Add aesthetic date
        mav.addObject("searchDate", stringDate);
        //Add original search date format
        mav.addObject("inputDate", searchDate);
        return mav;
    }

    @RequestMapping(path = "/lottery", method = RequestMethod.GET)
    public ModelAndView enterLottery(@CookieValue(value = "userId",defaultValue = "null") String userId, @RequestParam(value="search-date", defaultValue = "null") String searchDate,
                                     @RequestParam(value="lotteryLocation", defaultValue = "null") String deskLocation){
        ModelAndView mav = new ModelAndView();
        int userID = Integer.parseInt(userId);
        DateFormatter prettyDate = new DateFormatter();
        if(!userRepo.checkUserInLottery(searchDate, deskLocation, userID)){
            if(userRepo.addUserToLottery(searchDate, deskLocation, userID)){
                mav.addObject("lottery", deskLocation);
                String numberInLottery = Integer.toString(userRepo.checkNumberInLottery(searchDate, deskLocation));
                mav.addObject("numberInLottery", numberInLottery);
                System.out.println(userRepo.checkNumberInLottery(searchDate, deskLocation));
            }
        }else{
            mav.addObject("lotteryFail", (deskLocation));
        }
        mav.addObject("date", prettyDate.formatDate(searchDate));
        mav.setViewName("bookingConfirmation");
        return mav;

    }

    @RequestMapping(path = "/lottery/admin", method = RequestMethod.GET)
    public ModelAndView adminEnterLottery(@RequestParam(value="search-date", defaultValue = "null") String searchDate,
                                     @RequestParam(value="lotteryLocation", defaultValue = "null") String deskLocation,
                                     @RequestParam(value="usrID", defaultValue = "null") String usrID){
        ModelAndView mav = new ModelAndView();
        int userID = Integer.parseInt(usrID);
        DateFormatter prettyDate = new DateFormatter();
        List<UserDTO> userList = userRepo.getAllUsers();
        if(!userRepo.checkUserInLottery(searchDate, deskLocation, userID)){
            if(userRepo.addUserToLottery(searchDate, deskLocation, userID)){
                mav.addObject("lottery", deskLocation);
                String numberInLottery = Integer.toString(userRepo.checkNumberInLottery(searchDate, deskLocation));
                mav.addObject("numberInLottery", numberInLottery);

            }
        }else{
            mav.addObject("lotteryFail", (deskLocation));
        }
        for(UserDTO user: userList){
            if(user.getUser_id() == userID){
                mav.addObject("user", user);
                break;
            }
        }
        mav.addObject("users", userRepo.getAllUsers());
        mav.addObject("locations", userRepo.getAllLocations());
        mav.addObject("date", prettyDate.formatDate(searchDate));
        mav.setViewName("Admin_Createbooking");
        return mav;

    }



}
