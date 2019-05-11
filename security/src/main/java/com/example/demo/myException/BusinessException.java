package com.example.demo.myException;

public class BusinessException extends RuntimeException {

    public BusinessException(){}

    public BusinessException(String msg){
        super(msg);
    }
}
