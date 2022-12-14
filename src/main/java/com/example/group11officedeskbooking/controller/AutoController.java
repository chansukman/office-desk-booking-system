package com.example.group11officedeskbooking.controller;

import com.alibaba.fastjson.JSON;
import com.example.group11officedeskbooking.DTO.GithubUser;
import com.example.group11officedeskbooking.DTO.UserDTO;
import com.example.group11officedeskbooking.helper.HttpHelper;
import com.example.group11officedeskbooking.repository.UserRepository;
import com.example.group11officedeskbooking.repository.UserRepositoryJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AutoController {
    private UserRepository userRepository;

    public AutoController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private HttpHelper httpHelper;
    String client_id = "acd4376fd4158e948c1a";
    String client_secret = "542a5a27d415ac3c022773f3ea788d3c8016d5ec";


    @RequestMapping("/callback")
    @ResponseBody
    public String callback(HttpServletResponse response2, @RequestParam("code") String code) throws IOException {
        //1.code form callback_uri
        Map<String, Object> map = new HashMap<>();
        map.put("client_id", client_id);
        map.put("client_secret", client_secret);
        map.put("code", code);
        map.put("redirect_url", "http://20.26.197.144:80/callback");
        map.put("state", "test");
        String url = "https://github.com/login/oauth/access_token";
        String json = JSON.toJSONString(map);
        String result = httpHelper.Post(url, json);//access_token=your_client_id&scope=user&token_type=bearer

        String[] strs = result.split("&");
        String access_token = strs[0].split("=")[1];
        String userInfo = httpHelper.Get(access_token);
        GithubUser githubUser = JSON.parseObject(userInfo, GithubUser.class);
        Integer gitUserId = githubUser.getId();
        String gitUserName = githubUser.getLogin();
        try {
            UserDTO userDTO = (UserDTO) userRepository.checkUserExist(gitUserId);
            Integer checkUserId = userDTO.getUser_id();
            if (checkUserId != null) {
                Cookie userID = new Cookie("userId", gitUserId.toString());
                Cookie userName = new Cookie("userName", gitUserName);
                response2.addCookie(userID);
                response2.addCookie(userName);
                ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                assert sra != null;
                HttpServletResponse response = sra.getResponse();
                response.sendRedirect("/dashboard");
            }
        } catch (Exception e) {
            userRepository.addSSOUser(gitUserId, gitUserName);
            Cookie userID = new Cookie("userId", gitUserId.toString());
            Cookie userName = new Cookie("userName", gitUserName);
            response2.addCookie(userID);
            response2.addCookie(userName);
            ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert sra != null;
            HttpServletResponse response = sra.getResponse();
            response.sendRedirect("/dashboard");
        }
        return userInfo;
    }
}