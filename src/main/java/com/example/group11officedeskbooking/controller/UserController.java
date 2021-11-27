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

@Controller
public class UserController {


    //    @RequestMapping(path = "/userlogin", method = RequestMethod.POST)
//    public String usercheck(UserForm user,AdminForm admin,@RequestParam(value="button") String btn) {
//        //commonUser
//        UserForm Shuwen = new UserForm("21","shuwen", "123456");
//        UserForm Dan = new UserForm("22","dan", "123456");
//        UserForm Mahhd=new UserForm("23","mahad","123456");
//        UserForm Abdullah=new UserForm("24","abdullah","123456");
//        ArrayList<UserForm> listOfcommonuser = new ArrayList<>();
//        listOfcommonuser.add(Shuwen);
//        listOfcommonuser.add(Dan);
//        listOfcommonuser.add(Mahhd);
//        listOfcommonuser.add(Abdullah);
//
//        //AdminUser
//        AdminForm Admin=new AdminForm("1","admin","admin");
//        ArrayList<AdminForm> listOfadminuser =new ArrayList<>();
//        listOfadminuser.add(Admin);
//
//
//        System.out.print("logging");
//        if (btn.equals("User LOGIN")) {
//            for (int i = 0; i < listOfcommonuser.size(); i++) {
//                if (user.getUsername().equals(listOfcommonuser.get(i).getUsername()) && user.getPassword().equals(listOfcommonuser.get(i).getPassword())) {
//
//                    return "redirect:bookings";
//                }
//            }
//        }
//        else if(btn.equals("Admin LOGIN")){
//            for(int j=0;j<listOfadminuser.size();j++){
//                if(admin.getUsername().equals(listOfadminuser.get(j).getUsername())&&admin.getPassword().equals(listOfadminuser.get(j).getPassword()))
//                {
//                    return "redirect:bookings";
//                }
//            }
//        }
//        System.out.println("read the file");
//        return "redirect:login";
//
//    }
//
    @Resource
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository newuser) {
        userRepository = newuser;
    }

    @RequestMapping(path = "/userlogin", method = RequestMethod.POST)

    public ModelAndView checkUser(UserDTO userDTO, AdminDTO adminDTO, @RequestParam(value = "first_name") String username, @RequestParam(value = "password") String password, @RequestParam(value="button") String btn) {
        ModelAndView mav = new ModelAndView();
        if (btn.equals("User LOGIN")) {
            try {
                userRepository.checkByFirstnameAndPassword(username, password);
                if (userDTO.getFirst_name().equals(username) && userDTO.getPassword().equals(password)) {
                    System.out.println(userDTO.getFirst_name());
                  System.out.println(userDTO.getPassword());

                    mav.addObject("User",userRepository.checkByFirstnameAndPassword(username,password));
                    mav.setViewName("dashboard");
                    return mav;

                }
            } catch (Exception e) {
                mav.addObject("msg","wrong username or password");
                mav.setViewName("login");
                return mav;
            }
        }else if (btn.equals("Admin LOGIN"))
        {
            try {
                userRepository.checkAdminByFistnameAndPassword(username, password);
                if (adminDTO.getFirst_name().equals(username) && adminDTO.getPassword().equals(password)) {

                    mav.addObject("Admin",userRepository.checkAdminByFistnameAndPassword(username,password));
                    mav.setViewName("dashboard");
                    return mav;
                }
            } catch (Exception e) {
                mav.addObject("msg","wrong username or password");
                mav.setViewName("login");
                return  mav;
            }

        }
        mav.setViewName("login");
        return  mav;
    }


}
