package com.chen.springboot.dao;


import com.chen.springboot.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Mapper
public interface UserDao {

    User findUserId(int id);
}
