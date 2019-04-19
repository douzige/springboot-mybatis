package com.chen.springboot.controller;

import com.chen.springboot.po.User;
import com.chen.springboot.request.RequestGetUser;
import com.chen.springboot.respones.Response;
import com.chen.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/get/{id}")
    public User findUserId(@PathVariable("id") int id) {
        User  user = userService.findUserId(id);
        return user;
    }

    @PostMapping(value = "/getUser")
    public Response GetUser(@Valid @RequestBody RequestGetUser requestGetUser) {
        Response<User> response = new Response();
        User user = userService.findUserId(requestGetUser.getId());
//        response.setStatus();
        response.setConnt(user);
        
        return response;


    }
}
