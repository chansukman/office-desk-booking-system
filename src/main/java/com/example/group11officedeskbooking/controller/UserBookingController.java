package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.DTO.DeskDTO;
import com.example.group11officedeskbooking.DTO.UserDTO;
import com.example.group11officedeskbooking.DateFormatter;
import com.example.group11officedeskbooking.repository.UserBookingRepository;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Controller
public class UserBookingController {
    private UserBookingRepository bookingRepo;

    @Autowired
    public UserBookingController(UserBookingRepository uRepo){
        bookingRepo = uRepo;
    }

    //Http get request from localhost with the user ID routing
    @RequestMapping(path = "/mybooking")
    public ModelAndView mybooking(@CookieValue(value="userId", required = false) String userId){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("allbooking");
        return mav;
    }

    @RequestMapping(path = "/mybooking/upcoming")
    public ModelAndView searchUpcoming(@CookieValue(value="userId", required = false) String userId){
        ModelAndView mav = new ModelAndView();
        mav.addObject("bookingList",bookingRepo.findUpcomingBookingByUserID(Integer.parseInt(userId)));
        mav.setViewName("allbooking");
        return mav;
    }

    @RequestMapping(path = "/mybooking/lottery")
    public ModelAndView searchLottery(@CookieValue(value="userId", required = false) String userId){
        ModelAndView mav = new ModelAndView();
        mav.addObject("lotteryList",bookingRepo.getAllUserLotteryEntries(Integer.parseInt(userId)));
        mav.setViewName("allbooking");
        return mav;
    }

    @RequestMapping(path = "/mybooking/previous")
    public ModelAndView searchPrevious(@CookieValue(value="userId", required = false) String userId){
        ModelAndView mav = new ModelAndView();
        mav.addObject("bookingList",bookingRepo.findPreviousBookingByUserID(Integer.parseInt(userId)));
        mav.setViewName("allbooking");
        return mav;
    }

    @RequestMapping(path = "/booking/{userID}/{deskID}/{date}/{admin}")
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

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("smtp.gmail.com");
            mailSender.setPort(587);
            mailSender.setUsername("testercardiff123@gmail.com");
            mailSender.setPassword("Tester@cardiff123");

            try {
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true);

                UserDTO user = bookingRepo.findUserByUserID(inputUserID);

                if (user.getEmail() != null){
                    helper.setTo(user.getEmail());
                    helper.setSubject("Booking Confirmed!");
                    helper.setText("Hello " + user.getFirst_name() + ",\nWe just wanted to let you know that your booking for "
                            + prettyDate.formatDate(inputDate)
                            + " on desk " + inputDeskID + " has been confirmed! \n" +
                            "Please login to " + " http://localhost:8080/mybooking " + " to see your bookings. " +
                            "\n\nRegards," +
                            "\nADMS Team");

                    mailSender.setJavaMailProperties(props);
                    mailSender.send(message);
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }

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
