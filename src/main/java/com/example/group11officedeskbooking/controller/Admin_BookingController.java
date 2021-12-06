package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.repository.Admin_BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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

    // Deleting All Bookings

    @RequestMapping(path = "admin/bookings/delete/{booking_id}")
    public ModelAndView deleteBooking(@PathVariable Optional<String> booking_id) {
        int id = Integer.parseInt(booking_id.get());
        ModelAndView mav = new ModelAndView();
        admin_bookingRepository.deleteById(id);
        mav.addObject("adminBookingList", admin_bookingRepository.findAll());
        mav.setViewName("Admin_AllBookings");
        return mav;
    }


}
