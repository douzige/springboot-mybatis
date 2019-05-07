package com.chen.springboot.dao;


import com.chen.springboot.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
@Mapper
public interface UserDao {
    /**
     *
     * @param id  userid
     * @return
     */

    User findUserId(int id);

    /**
     *
     * @param loginName
     * @param password
     * @return
     */
    User findUserAndPw(@Param("loginName") String loginName,@Param("password") String password);

    /**
     *
     * @param id id
     * @return
     */
    int deletUser(@Param("id") int id);

    /**
     * 添加用户
     * @param user
     * @return
     */

    int addUser(User user);


    int  updateUser(User user);
}
