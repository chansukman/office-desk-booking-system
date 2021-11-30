package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.repository.UserBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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

    @RequestMapping(path = "/booking/{userID}/{deskID}/{date}")
    public ModelAndView processBooking(@PathVariable Optional<String> userID, @PathVariable Optional<String> deskID, @PathVariable Optional<String> date){
        //Need to make call to the database to insert booking
        //data needed for booking is:
        if(bookingRepo.addBooking(Integer.parseInt(userID.get()), date.get(), Integer.parseInt(deskID.get()))){

        }

        System.out.println(userID.get());
        System.out.println(deskID.get());
        System.out.println(date.get());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("dashboard");
        return mav;
    }
}
