package com.chen.springboot.po;

import lombok.Data;

import java.util.Date;
@Data
public class User {

    private int id;
    private String  code;
    private String  name;
    private String  loginName;

    private String  password;
    private int  status;
    private int  isAdmin;
    private int  statusFlag;
    private Date  serverCreateTime;
    private Date serverUpdateTime;




}
