package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.repository.UserBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserBookingController {
    private UserBookingRepository bookingRepo;

    @Autowired
    public UserBookingController(UserBookingRepository uRepo){
        bookingRepo = uRepo;
    }
    //Http get request from localhost with the user ID routing
    @RequestMapping(path = "/mybooking", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(value = "id") int id ){
        ModelAndView mav = new ModelAndView();
        mav.addObject("bookingList",bookingRepo.findBookingByUserId(id));
        mav.setViewName("allbooking");
        return mav;
    }
}
