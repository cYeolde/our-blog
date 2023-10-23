package com.example.server.vo;

import com.example.server.enums.ResultEnum;

public class Result<T> {
    public int code;
    public String message;
    public T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultEnum.SUCCESS.getMsg(), ResultEnum.SUCCESS.getCode(), data);
    }
    public static <T> Result<T> success() {
        return (new Result<>(ResultEnum.SUCCESS.getMsg(), ResultEnum.SUCCESS.getCode(), null));
    }
    public static <T> Result<T> error() {
        return (new Result<>(ResultEnum.ERROR_UNKNOWN.getMsg(), ResultEnum.ERROR_UNKNOWN.getCode(), null));
    }
    public static <T> Result<T> error(ResultEnum rEnum) {
        return (new Result<>(rEnum.getMsg(), rEnum.getCode(), null));
    }
    private Result(String msg, int code, T data) {
        this.message = msg;
        this.code = code;
        this.data = data;
    }
}
