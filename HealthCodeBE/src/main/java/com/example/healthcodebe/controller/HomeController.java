package com.example.healthcodebe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class HomeController {
    @RequestMapping("/hello.json")
    public @ResponseBody String Hello(){
        return "Hello World!";
    }
}
