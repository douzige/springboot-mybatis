package com.chen.springboot.controller;

import com.chen.springboot.respones.Response;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@ControllerAdvice
public class myExceptionHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Response<?> testException(MethodArgumentNotValidException ex, HttpServletRequest request){
        Response<?>  response  = new Response<>();
        response.setMessage(ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(";")));
        return response;
    }
    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Response<?> handleException(Throwable ex) {
        Response<?> response = new Response<>();
        response.setMessage("服务器内部错误");
        System.out.println(ex);
        return response;
    }
    @ExceptionHandler(value = {HttpMessageNotReadableException.class, JsonMappingException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Response<?> handleException(Exception ex) {
        Response<?> response = new Response<>();
        response.setMessage("json格式错误");
        return response;
    }


}
