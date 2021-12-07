package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.DateFormatter;
import com.example.group11officedeskbooking.repository.DeskRepository;
import com.example.group11officedeskbooking.repository.MapRepository;
import com.example.group11officedeskbooking.repository.UserBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
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

        if(stringDate.charAt(0) == 'S'){
            mav.addObject("unavailable", "Sorry, desks are not bookable at the weekend");
            return mav;
        }

        //Add map and desk to mav
        mav.addObject("map", mapRepo.searchMap(deskLocation));
        mav.addObject("deskList", deskRepo.searchAvailableDesksByDate(searchDate, deskLocation));
        mav.addObject("location", deskLocation);
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
                mav.addObject("numberInLottery", userRepo.checkNumberInLottery(searchDate, deskLocation));
            }
        }else{
            mav.addObject("lotteryFail", deskLocation);
        }
        mav.addObject("date", prettyDate.formatDate(searchDate));
        mav.setViewName("bookingConfirmation");
        return mav;

    }

}
