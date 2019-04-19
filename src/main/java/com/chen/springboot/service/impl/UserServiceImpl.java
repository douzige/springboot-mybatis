package com.chen.springboot.service.impl;


import com.chen.springboot.dao.UserDao;
import com.chen.springboot.po.User;
import com.chen.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserId(int id) {

        return userDao.findUserId(id);
    }
}
