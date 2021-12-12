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
        //1.code参数为github回调callback_uri时，github传递过来的
        System.out.println("请求callback...,code:" + code);
        Map<String, Object> map = new HashMap<>();
        map.put("client_id", client_id);
        map.put("client_secret", client_secret);
        map.put("code", code);
        map.put("redirect_url", "http://localhost:8080/callback");
        map.put("state", "test");
        //获取access token
        String url = "https://github.com/login/oauth/access_token";
        String json = JSON.toJSONString(map);
        //2.根据传入的参数（包含code），post请求https://github.com/login/oauth/access_token，获取返回值
        String result = httpHelper.Post(url, json);//access_token=your_client_id&scope=user&token_type=bearer
        System.out.println("callback result:" + result);

        String[] strs = result.split("&");
        String access_token = strs[0].split("=")[1];//解析access_token

        //3.根据access token,请求https://api.github.com/user获取用户信息
//            String url_user = "https://api.github.com/user?access_token=" + access_token;
        String userInfo = httpHelper.Get(access_token);
//            System.out.println("userInfo:" + userInfo);//返回的是一个json字符串
        GithubUser githubUser = JSON.parseObject(userInfo, GithubUser.class);
        Integer gitUserId = githubUser.getId();
        String gitUserName = githubUser.getLogin();
        System.out.println(gitUserId + gitUserName);
        try {
            UserDTO userDTO = (UserDTO) userRepository.checkUserExist(gitUserId);
            Integer checkUserId = userDTO.getUser_id();
            System.out.println(checkUserId);
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