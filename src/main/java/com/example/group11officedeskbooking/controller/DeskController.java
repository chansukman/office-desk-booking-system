package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.repository.DeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeskController {

    private DeskRepository deskRepo;

    @Autowired
    public DeskController(DeskRepository newRepo){
        deskRepo = newRepo;
    }

    @RequestMapping(path = "/searchDate2", method = RequestMethod.GET)
    public ModelAndView searchDate(@RequestParam(value="date", defaultValue = "null") String searchDate){
        ModelAndView mav = new ModelAndView();
        mav.addObject(deskRepo.searchAvailableDesksByDate(searchDate));
        mav.setViewName("bookings");
        return mav;
    }

}
