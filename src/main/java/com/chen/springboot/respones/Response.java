package com.chen.springboot.respones;


import java.sql.Timestamp;

public class Response<T> {

    protected Integer status;
    protected String message;
    protected T connt;

    protected Long timestamp = System.currentTimeMillis();

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getConnt() {
        return connt;
    }

    public void setConnt(T connt) {
        this.connt = connt;
    }
}
