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


    @Autowired
    public DeskController(DeskRepository newRepo, MapRepository mapRepo){
        this.deskRepo = newRepo;
        this.mapRepo = mapRepo;
    }

    public String formatDate(String date){

        //Separate date components
        String[] dateComponents = date.split("-");
        int year = Integer.parseInt(dateComponents[0]);
        int month = Integer.parseInt(dateComponents[1]) - 1;
        int day = Integer.parseInt(dateComponents[2]);

        //Convert to date format
        Calendar tempCal = new GregorianCalendar(year, month, day);
        Date newSearchDate = tempCal.getTime();
        SimpleDateFormat DateFor = new SimpleDateFormat("EEEE d'th' MMM yyyy");

        //add
        if(day == 1 || day == 21 || day == 31){
            DateFor = new SimpleDateFormat("EEEE d'st' MMM yyyy");
        }
        else if(day == 2 || day == 22){
            DateFor = new SimpleDateFormat("EEEE d'nd' MMM yyyy");
        }
        else if(day == 3 || day == 23){
            DateFor = new SimpleDateFormat("EEEE d'rd' MMM yyyy");
        }
        return DateFor.format(newSearchDate);
    }

    @RequestMapping(path = "/searchDate", method = RequestMethod.GET)
    public ModelAndView searchDate(@RequestParam(value="date", defaultValue = "null") String searchDate,
                                   @RequestParam(value="location", defaultValue = "null") String deskLocation){
        ModelAndView mav = new ModelAndView();
        //Validation
        if(searchDate.equals("null") || deskLocation.equals("null")){
            mav.setViewName("bookings");
            return mav;
        }

        String stringDate = formatDate(searchDate);

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



}
