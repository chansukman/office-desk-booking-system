package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.DTO.Admin_BookingDTO;
import com.example.group11officedeskbooking.repository.Admin_BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.crypto.Data;
import java.util.Date;

@RestController
public class Admin_BookingController {

    private final Admin_BookingRepository admin_bookingRepository;

    @Autowired
    public Admin_BookingController(Admin_BookingRepository admin_bookingRepository) {
        this.admin_bookingRepository = admin_bookingRepository;
    }

    // Showing All Bookings

    @RequestMapping(path = "admin/bookings", method = RequestMethod.GET)
    public ModelAndView fetchAllRecords(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("adminBookingList", admin_bookingRepository.findAll());
        mav.setViewName("Admin_AllBookings");
        return mav;
    }

    // Editing All Bookings

    @RequestMapping(path = "admin/bookings/edit", method = RequestMethod.PUT)
    public ModelAndView editBooking(@RequestBody Admin_BookingDTO admin_bookingDTO) {
        ModelAndView mav = new ModelAndView("redirect:/");
        admin_bookingRepository.update_records(admin_bookingDTO);
        mav.setViewName("editBooking");
        return mav;
    }
}
