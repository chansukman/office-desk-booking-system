package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.repository.UserTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookingDeleteController {
    private UserTaskRepository userTaskRepository;

    @Autowired
    public BookingDeleteController(UserTaskRepository uRepo) {
        this.userTaskRepository = uRepo;
    }

    @RequestMapping(path = "/mybooking/cancel")
    public ModelAndView search(@RequestParam(value = "id") int id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject(userTaskRepository.updateCancelTable(id));
        mav.addObject(userTaskRepository.deleteBooking(id));
        mav.setViewName("redirect:/mybooking/upcoming/");
        return mav;
    }
}
