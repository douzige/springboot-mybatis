package com.chen.springboot.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author ceshi_chen
 * @version $Id: RequestUserId,  2019/5/6 13:57 ceshi_chen Exp$
 */
@Data
public class RequestUserId {

    @NotNull(message = "id 不能为空")
    private int id;
}
