package com.chen.springboot.controller;

import com.chen.springboot.po.User;
import com.chen.springboot.request.RequestGetUser;
import com.chen.springboot.respones.Response;
import com.chen.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController

public class HomeController {

    @GetMapping("/Home")
    public String Home() {
        return "Hello  SpringBoot";
    }



}
