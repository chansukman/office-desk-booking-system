package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.repository.ReceptionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReceptionistController {
    private ReceptionistRepository receptionistRepo;

    @Autowired
    public ReceptionistController(ReceptionistRepository uRepo){this.receptionistRepo = uRepo;}

    @RequestMapping(path = "/daily")
    public ModelAndView search(@RequestParam(value = "location") String deskLocation) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("dailyList", receptionistRepo.getDailyBooking(deskLocation));
        mav.setViewName("dailyBooking");
        return mav;
    }
}
