package com.chen.springboot.request;

import lombok.Data;

/**
 * @author ceshi_chen
 * @version $Id: RequestUpdateUserInfo,  2019/5/7 13:51 ceshi_chen Exp$
 */
@Data
public class RequestUpdateUserInfo {
    private int id;
    private String code;

    private String name;

    private String loginName;

    private String password;

}
