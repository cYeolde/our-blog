package com.example.server.exception;

import com.example.server.enums.ResultEnum;

public class PoiException extends RuntimeException {
    public PoiException(String message) {
        super(message);
    }

    public static PoiException notFound() {
        return new PoiException(ResultEnum.ERROR_NOT_FOUND.getMsg());
    }

    public static PoiException OperateFail(){
        return new PoiException(ResultEnum.ERROR_OPERATION.getMsg());
    }

    public static PoiException Unknown() {
        return new PoiException(ResultEnum.ERROR_UNKNOWN.getMsg());
    }
}
