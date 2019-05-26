package com.join.learn.ssm.exception;

import com.join.learn.ssm.model.ResultResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理
 * @author join
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public ResultResponse<Void> handleCustomException(Exception e){
        ResultResponse<Void> resultResponse=new ResultResponse<>("1",e.getLocalizedMessage());
        return resultResponse;
    }
}
