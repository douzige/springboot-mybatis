package com.chen.springboot.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * @author ceshi_chen
 * @version $Id: RequestLogin,  2019/5/6 10:33 ceshi_chen Exp$
 */
@Data
public class RequestLogin {
    @NotBlank(message="登录名不能为空！")
    @Size(min=6, max=50,message = "长度在6到50字符之间")
    private String  username;
    @NotBlank(message = "密码不能为空")
    @Size(min=6, max=50,message = "长度在6到50字符之间")
    private String  password;
}
