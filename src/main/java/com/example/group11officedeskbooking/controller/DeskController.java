package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.DTO.DeskDTO;
import com.example.group11officedeskbooking.DTO.MapDTO;
import com.example.group11officedeskbooking.repository.DeskRepository;
import com.example.group11officedeskbooking.repository.MapRepository;
import com.example.group11officedeskbooking.repository.UserBookingRepository;
import com.example.group11officedeskbooking.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView searchDate(@RequestParam(value="date", defaultValue = "null") String searchDate, @RequestParam(value="location", defaultValue = "null") String deskLocation){
        ModelAndView mav = new ModelAndView();
        //Check inputs are not null
        if(searchDate.equals("null") || deskLocation.equals("null")){
            mav.setViewName("bookings");
            return mav;
        }

        //Create string of search date in aesthetic format
        String[] dateComponents = searchDate.split("-");
        int year = Integer.parseInt(dateComponents[0]);
        int month = Integer.parseInt(dateComponents[1]) - 1;
        int day = Integer.parseInt(dateComponents[2]);
        Calendar tempCal = new GregorianCalendar(year, month, day);
        System.out.println(tempCal.toString());
        Date newSearchDate = tempCal.getTime();
        System.out.println(newSearchDate.toString());
        SimpleDateFormat DateFor = new SimpleDateFormat("EEEE d'th' MMM yyyy");
        if(day == 1){
            DateFor = new SimpleDateFormat("EEEE d'st' MMM yyyy");
        }
        else if(day == 2){
            DateFor = new SimpleDateFormat("EEEE d'nd' MMM yyyy");
        }
        else if(day == 3){
            DateFor = new SimpleDateFormat("EEEE d'rd' MMM yyyy");
        }
        String stringDate = DateFor.format(newSearchDate);

        //Add map and desk to mav
        mav.addObject("map", mapRepo.searchMap(deskLocation));
        mav.addObject("deskList", deskRepo.searchAvailableDesksByDate(searchDate, deskLocation));

        //Add aesthetic date
        mav.addObject("searchDate", stringDate);
        //Add original search date format
        mav.addObject("inputDate", searchDate);
        mav.setViewName("bookings");
        return mav;
    }

    @RequestMapping(path = "/booking/{userID}/{deskID}/{date}")
    public ModelAndView processBooking(@PathVariable Optional<String> userID, @PathVariable Optional<String> deskID, @PathVariable Optional<String> date){
        //Need to make call to the datbase to insert booking
        //data needed for booking is:
        if(userRepo.addBooking(Integer.parseInt(userID.get()), date.get(), Integer.parseInt(deskID.get()))){

        }

        System.out.println(userID.get());
        System.out.println(deskID.get());
        System.out.println(date.get());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("dashboard");
        return mav;
    }

}
