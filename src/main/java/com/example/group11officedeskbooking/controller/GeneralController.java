package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.DTO.UserDTO;
import com.example.group11officedeskbooking.forms.DeskForm;
import com.example.group11officedeskbooking.repository.DeskRepository;
import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class GeneralController {

    //    When login by user, it will route you to the user dashboard

    @RequestMapping(path = "/dashboard")
    public ModelAndView dashboard(@CookieValue(value = "userId",defaultValue = "null") String userId){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("dashboard");
//        if(userId.equals("null")){
//            mav.setViewName("login");
//        }
        return mav;
    }

    @RequestMapping(path = "/bookings")
    public ModelAndView bookings(@CookieValue(value = "userId",defaultValue = "null") String userId){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("bookings");
        if(userId.equals("null")){
            mav.setViewName("login");
        }
        return mav;
    }


    @RequestMapping(path = "/login")
    public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
        if(request.getCookies()!=null) {
            Cookie[] myCookies = request.getCookies();
            for (int i = 0; i < myCookies.length; i++) {
                myCookies[i].setMaxAge(0);
                response.addCookie(myCookies[i]);
            }
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    //Routing for the Admin Home Page

    @RequestMapping(path = "/admin/home")
    public ModelAndView Admin_Home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Admin_Home");
        return mav;
    }

    //Routing for the Admin Location Bristol Page

    @RequestMapping(path = "/admin/location/bristol")
    public ModelAndView Admin_AllLocations_Bristol(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Admin_AllLocations_Bristol");
        return mav;
    }

    //Routing for the Admin Location Cardiff Page

    @RequestMapping(path = "/admin/location/cardiff")
    public ModelAndView Admin_AllLocations_Cardiff(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Admin_AllLocations_Cardiff");
        return mav;
    }
    @RequestMapping(path = "/Home")
    public ModelAndView home(@CookieValue(value = "userId",defaultValue = "null") String userId){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("dashboard");
        if(userId.equals("null")){
            mav.setViewName("login");
        }
        return mav;
    }




}
