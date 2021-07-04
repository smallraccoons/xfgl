package com.cc.xfgl.common.exxeption;

import com.cc.xfgl.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail();
    }

    @ExceptionHandler(XfglException.class)
    @ResponseBody
    public Result error(XfglException e){
        e.printStackTrace();
        return Result.fail();
    }
}
