package com.ceshi.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MyController {

//    @RequestMapping({"/","/login"})
//    public String ceshi(){
//        return "index";
//    }

      @PostMapping("/login/check")
      public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map){
          if(!StringUtils.isEmpty(username) && "123456".equals(password)){
              return "redirect:/main";
          }else {
              map.put("msg","Something is worng");
              return "index";
          }
      }


}
