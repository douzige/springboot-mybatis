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

    @Override
    public String findUserAndPw(String username, String psaaword) {
       User user =  userDao.findUserAndPw(username,psaaword);

       if (!(user ==null)){
           return "登录成功";
       }
        return "登录失败";
    }

    @Override
    public String deletUser(int id) {
        int i = userDao.deletUser(id);
        if (i>0){
            return "删除成功"+i;
        }
        return "删除失败";
    }

    @Override
    public String addUser(User user) {
        int i = userDao.addUser(user);
        return i+"";
    }

    @Override
    public String updateUser(User user) {
        int i = userDao.updateUser(user);
        if (i>0){
            return "更新成功！";
        }
        return "更新失败";
    }
}
