package com.chen.springboot.request;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;



import java.util.Date;
@Data
public  class RequestGetUser  {
//    @Null
    @Max(value = 10,message = "id不能大于10或者不能小于1")
    @Min(1)

    private Integer  id;
    @NotEmpty(message = "name 必须是一个非空的字符串")
    private String  name;

    private Date  date;



}
