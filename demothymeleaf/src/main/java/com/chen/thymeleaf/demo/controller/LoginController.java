package com.chen.thymeleaf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){

        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("user",username);
            return "redirect:/main";
        }else {
            map.put("msg","Something is worng");
            return "index";
        }
    }

    @RequestMapping("/")
    public String  hh(){
        return "index";
    }
}
