package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.repository.Admin_BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Admin_BookingController {

    private final Admin_BookingRepository admin_bookingRepository;

    @Autowired
    public Admin_BookingController(Admin_BookingRepository admin_bookingRepository) {
        this.admin_bookingRepository = admin_bookingRepository;
    }

    @RequestMapping(path = "admin/bookings", method = RequestMethod.GET)
    public ModelAndView fetchAllRecords(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("adminBookingList", admin_bookingRepository.findAll());
        mav.setViewName("Admin_AllBookings");
        return mav;
    }

}
