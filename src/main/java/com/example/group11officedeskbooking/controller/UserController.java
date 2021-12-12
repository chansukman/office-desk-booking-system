package com.example.group11officedeskbooking.controller;
import com.example.group11officedeskbooking.DTO.AdminDTO;
import com.example.group11officedeskbooking.DTO.UserDTO;
import com.example.group11officedeskbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Resource
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository newuser) {
        userRepository = newuser;
    }

    @RequestMapping(path = "/userlogin", method = RequestMethod.POST)
    public ModelAndView checkUser(HttpServletResponse response, UserDTO userDTO, @RequestParam(value = "first_name") String username, @RequestParam(value = "password") String password, @RequestParam(value="button") String btn) {
        ModelAndView mav = new ModelAndView();
            try {
                userRepository.checkByFirstnameAndPassword(username, password);
                if (userDTO.getFirst_name().equals(username) && userDTO.getPassword().equals(password)) {
                    mav.addObject("User",userRepository.checkByFirstnameAndPassword(username,password));
                    UserDTO user = (UserDTO) userRepository.checkByFirstnameAndPassword(username,password);
                    String userId = user.getUser_id().toString();
                    Cookie userID = new Cookie("userId", userId);
                    Cookie userName = new Cookie("userName", user.getFirst_name());
                    response.addCookie(userID);
                    response.addCookie(userName);
                    mav.addObject("userName", user.getFirst_name());
                    mav.setViewName("redirect:/dashboard");
                    return mav;

                }
            } catch (Exception e) {
                mav.addObject("msg","wrong username or password");
                mav.setViewName("login");
                return mav;
            }
        mav.setViewName("login");
        return  mav;
    }

    @RequestMapping(path = "/admin/home", method = RequestMethod.POST)

    public ModelAndView checkAdmin( AdminDTO adminDTO, @RequestParam(value = "first_name") String username, @RequestParam(value = "password") String password, @RequestParam(value="button") String btn) {
        ModelAndView mav = new ModelAndView();
            try {
                userRepository.checkAdminByFistnameAndPassword(username, password);
                if (adminDTO.getFirst_name().equals(username) && adminDTO.getPassword().equals(password)) {
                    mav.addObject("Admin",userRepository.checkAdminByFistnameAndPassword(username,password));
                    mav.setViewName("Admin_Home");
                    return mav;
                }
            } catch (Exception e) {
                mav.addObject("msg","wrong username or password");
                mav.setViewName("login");
                return  mav;
            }

        mav.setViewName("login");
        return  mav;
    }


}
