package com.zr.security.exception;

import com.zr.security.Utils.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServerException.class)
    public R serverException(ServerException e) {
        return R.error(e.getMsg());
    }
}
