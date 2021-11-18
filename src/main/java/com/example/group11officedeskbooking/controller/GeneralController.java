package com.example.group11officedeskbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralController {

    @RequestMapping(path = "/dashboard")
    public ModelAndView dashboard(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("dashboard");
        return mav;
    }

    @RequestMapping(path = "/bookings")
    public ModelAndView bookings(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("bookings");
        return mav;
    }

    @RequestMapping(path = "/searchDate", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(value="date") String date){
        ModelAndView mav = new ModelAndView();
        String[] testDesk = new String[5];
        testDesk[0] = "Desk 1";
        testDesk[1] = "Standard Desk";
        testDesk[2] = "Occupied";
        testDesk[3] = "image";
        testDesk[4] = date;
        mav.addObject("testDesk", testDesk);
        mav.setViewName("bookings");
        return mav;

    }

    @RequestMapping(path = "/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

}
