package com.inmeasure.common.config;

/**
 * 自定义业务异常类
 */
public class CustomException extends RuntimeException{
    //构造器
    public CustomException(String message){
        super(message);
    }
}
