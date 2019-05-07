package com.chen.springboot.service;


import com.chen.springboot.po.User;

public interface UserService {

    User findUserId(int id);

    /**
     * 登录
     * @param username  用户名
     * @param psaaword  密码
     * @return
     */
    String findUserAndPw(String username,String psaaword);

    /**
     * 删除用户
     * @param id  用户id
     */
    String  deletUser(int id);

    /**
     * 添加用户
     * @param user
     */
    String  addUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */

    String  updateUser(User user);
}
