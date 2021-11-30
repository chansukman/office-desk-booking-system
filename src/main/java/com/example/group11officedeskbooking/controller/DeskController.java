package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.DTO.DeskDTO;
import com.example.group11officedeskbooking.DTO.MapDTO;
import com.example.group11officedeskbooking.repository.DeskRepository;
import com.example.group11officedeskbooking.repository.MapRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public ModelAndView searchDate(@RequestParam(value="date", defaultValue = "null") String searchDate, @RequestParam(value="location", defaultValue = "null") String deskLocation){
        ModelAndView mav = new ModelAndView();
        //Check inputs are not null
        if(searchDate.equals("null") || deskLocation.equals("null")){
            mav.setViewName("bookings");
            return mav;
        }
        //Add map and desk to mav
        mav.addObject("map", mapRepo.searchMap(deskLocation));
        mav.addObject("deskList", deskRepo.searchAvailableDesksByDate(searchDate, deskLocation));
        mav.addObject("searchDate", searchDate);
        mav.setViewName("bookings");
        return mav;
    }

}
