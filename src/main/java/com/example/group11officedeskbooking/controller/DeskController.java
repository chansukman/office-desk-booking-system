package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.DateFormatter;
import com.example.group11officedeskbooking.repository.DeskRepository;
import com.example.group11officedeskbooking.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(path = "/searchDate", method = RequestMethod.GET)
    public ModelAndView searchDate(@RequestParam(value="date", defaultValue = "null") String searchDate,
                                   @RequestParam(value="location", defaultValue = "null") String deskLocation){
        ModelAndView mav = new ModelAndView();
        //Validation
        if(searchDate.equals("null") || deskLocation.equals("null")){
            mav.setViewName("bookings");
            return mav;
        }

        //Convert date string format
        DateFormatter prettyDate = new DateFormatter();
        String stringDate = prettyDate.formatDate(searchDate);

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
