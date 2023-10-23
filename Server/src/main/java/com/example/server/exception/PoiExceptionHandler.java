package com.example.server.exception;

import com.example.server.enums.ResultEnum;
import com.example.server.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class PoiExceptionHandler {
    @ExceptionHandler(PoiException.class)
    public Result<String> poiExceptionHandler(Exception e) {
        log.info("PoiExceptionHandler:{}", e.getMessage());
        if(e.getMessage().endsWith(ResultEnum.ERROR_NOT_FOUND.getMsg())){
            return Result.error(ResultEnum.ERROR_NOT_FOUND);
        } else if (e.getMessage().endsWith(ResultEnum.ERROR_OPERATION.getMsg())){
            return Result.error(ResultEnum.ERROR_OPERATION);
        } else if (e.getMessage().endsWith(ResultEnum.ERROR_UNKNOWN.getMsg())){
            return Result.error(ResultEnum.ERROR_UNKNOWN);
        } else {
            return Result.error();
        }
    }

    @ExceptionHandler(Exception.class)
    public Result<String> serverErrorHandler(Exception e) {
        log.info("ExceptionHandler:{}", e.getMessage());
        return Result.error();
    }
}
