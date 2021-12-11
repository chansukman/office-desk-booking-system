package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.DTO.UserDTO;
import com.example.group11officedeskbooking.DateFormatter;
import com.example.group11officedeskbooking.repository.UserBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class UserBookingController {
    private UserBookingRepository bookingRepo;

    @Autowired
    public UserBookingController(UserBookingRepository uRepo){
        bookingRepo = uRepo;
    }

    //Http get request from localhost with the user ID routing
    @RequestMapping(path = "/mybooking")
    public ModelAndView search(@CookieValue(value="userId", required = false) String userId){
        ModelAndView mav = new ModelAndView();
        mav.addObject("bookingList",bookingRepo.findBookingByUserId(Integer.parseInt(userId)));
        mav.setViewName("allbooking");
        return mav;
    }

    @RequestMapping(path = {"/booking/{userID}/{deskID}/{date}", "/booking/{userID}/{deskID}/{date}/{admin}"})
    public ModelAndView processBooking(@PathVariable Optional<String> userID, @PathVariable Optional<String> deskID, @PathVariable Optional<String> date, @PathVariable Optional<String> admin){
        //Convert inputs to required types
        int inputUserID = Integer.parseInt(userID.get());
        String inputDate = date.get();
        int inputDeskID = Integer.parseInt(deskID.get());
        ModelAndView mav = new ModelAndView();
        //Perform add booking to repo if not return mav without booking object
        if(bookingRepo.addBooking(inputUserID, inputDate, inputDeskID)){
            mav.addObject("booking", bookingRepo.getUniqueBooking(inputDate, inputDeskID));
            DateFormatter prettyDate = new DateFormatter();
            mav.addObject("date", prettyDate.formatDate(inputDate));
        }
        mav.setViewName("bookingConfirmation");
        if(admin.isPresent()){
            List<UserDTO> userList = bookingRepo.getAllUsers();
            mav.addObject("users", userList);
            mav.addObject("locations", bookingRepo.getAllLocations());
            for(UserDTO user: userList){
                if(user.getUser_id() == inputUserID){
                    mav.addObject("bookedUser", user);
                    break;
                }
            }
            mav.setViewName("Admin_CreateBooking");
        }
        return mav;
    }
}
