package com.chen.springboot.controller;

import com.chen.springboot.po.User;
import com.chen.springboot.request.*;
import com.chen.springboot.respones.Response;
import com.chen.springboot.service.UserService;
import org.springframework.beans.BeanUtils;
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
    public Response getUser(@Valid @RequestBody RequestGetUser requestGetUser) {
        Response<User> response = new Response();
        User user = userService.findUserId(requestGetUser.getId());

        response.setConnt(user);
        
        return response;


    }
    @PostMapping("/login")
    public  Response longin(@Valid @RequestBody RequestLogin requestLogin){
        Response<User> response = new Response();
        String  String = userService.findUserAndPw(requestLogin.getUsername(),requestLogin.getPassword());
        response.setMessage(String);
        return response;
    }
    @PostMapping("/delet")
    public  Response  delet(@Valid @RequestBody RequestUserId requestUserId){
        Response<User> response = new Response();
        String str =  userService.deletUser(requestUserId.getId());

        response.setMessage(str);
        return  response;
    }
    @PostMapping("/add")
    public  Response add(@Valid @RequestBody RequestAddUserInfo requestAddUserInfo){
        Response<User> response = new Response();
//        System.out.println(requestAddUserInfo);
        User  user = new User();
//        user.setCode(requestAddUserInfo.getCode());
//        user.setLoginName(requestAddUserInfo.getLoginName());
//        user.setName(requestAddUserInfo.getName());
//        user.setPassword(requestAddUserInfo.getPassword());
        BeanUtils.copyProperties(requestAddUserInfo,user);
        String str =  userService.addUser(user);
        response.setMessage(str);
        return response;

    }

    /**
     * 更新用户
     * @param requestUpdateUserInfo
     * @return
     */
    @PostMapping("/update")
    public  Response updateUser(@Valid @RequestBody RequestUpdateUserInfo requestUpdateUserInfo){
        Response<User> response = new Response();
        User  user = new User();
        BeanUtils.copyProperties(requestUpdateUserInfo,user);

        String str = userService.updateUser(user);
        response.setMessage(str);

        return response;

    }



}
