package com.miaoshaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController extends BaseController{
    @RequestMapping({"/","login.html"})
    public String login(){
        return "getOtp";
    }
}
