package com.chen.thymeleaf.demo.controller;

import com.chen.thymeleaf.demo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Controller
public class TestController {

//    @RequestMapping({"/","/index.html"})
//    public String login(){
//        return "index";
//    }

    @RequestMapping("/hello")
    public String demoHello(Map<String, Object> map){

        map.put("hello","wangbadan");


        return "demo";
    }
}
