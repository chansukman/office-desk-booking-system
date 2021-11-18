package com.example.group11officedeskbooking.controller;

import com.example.group11officedeskbooking.forms.AdminForm;
import com.example.group11officedeskbooking.forms.DeskForm;
import com.example.group11officedeskbooking.forms.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class UserController {

    @RequestMapping(path = "/userlogin", method = RequestMethod.POST)
    public String usercheck(UserForm user,AdminForm admin,@RequestParam(value="button") String btn) {
        //commonUser
        UserForm Shuwen = new UserForm("shuwen", "123456");
        UserForm Dan = new UserForm("dan", "123456");
        ArrayList<UserForm> listOfcommonuser = new ArrayList<>();
        listOfcommonuser.add(Shuwen);
        listOfcommonuser.add(Dan);

        //AdminUser
        AdminForm Admin=new AdminForm("admin","admin");
        ArrayList<AdminForm> listOfadminuser =new ArrayList<>();
        listOfadminuser.add(Admin);


        System.out.print("logging");
        if (btn.equals("User LOGIN")) {
            for (int i = 0; i < listOfcommonuser.size(); i++) {
                if (user.getUsername().equals(listOfcommonuser.get(i).getUsername()) && user.getPassword().equals(listOfcommonuser.get(i).getPassword())) {
                    return "redirect:bookings";
                }
            }
        }
        else if(btn.equals("Admin LOGIN")){
            for(int j=0;j<listOfadminuser.size();j++){
                if(admin.getUsername().equals(listOfadminuser.get(j).getUsername())&&admin.getPassword().equals(listOfadminuser.get(j).getPassword()))
                {
                    return "redirect:bookings";
                }
            }
        }
        return "redirect:login";

    }

}
