package com.chen.springboot.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author ceshi_chen
 * @version $Id: RequestAddUserInf,  2019/5/6 14:25 ceshi_chen Exp$
 */
@Data
public class RequestAddUserInfo {
    @NotNull(message = "编码不能为空")
    private String code;
    @NotNull(message = "姓名不能为空")
    private String name;
    @NotNull(message = "登录名不能为空")
    private String loginName;
    @NotNull(message = "密码不能为空")
    private String password;

}
