package com.example.server.enums;

import lombok.Getter;

public enum ResultEnum {
    SUCCESS(0,"操作成功"),
    ERROR_UNKNOWN(-1,"未知错误"),
    ERROR_NOT_FOUND(1,"资源未找到"),
    ERROR_OPERATION(2,"操作不成功"),
    ;


    int code;
    @Getter
    String msg;

    ResultEnum(int code, String msg){
        this.code=code;
        this.msg=msg;

    }

    public Integer getCode(){
        return this.code;
    }

}
