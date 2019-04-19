package com.chen.springboot.controller;

import com.chen.springboot.respones.Response;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
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
//        Integer statusCode = (Integer) request
//                .getAttribute("javax.servlet.error.status_code");
//        request.setAttribute("javax.servlet.error.status_code",400);
        Response<?>  response  = new Response<>();
//        response.setStatus(200);
//        BindingResult bindingResult = ex.getBindingResult();
//        response.setMessage(bindingResult.getFieldError().getDefaultMessage());
        response.setMessage(ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(";")));
        return response;
    }
    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Response<?> handleException(Throwable ex) {
        Response<?> response = new Response<>();
//        response.setStatus(200);
        response.setMessage("服务器内部错误");
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
