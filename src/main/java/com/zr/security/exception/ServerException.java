package com.zr.security.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ServerException extends RuntimeException {

    private int code;

    private String msg;

    public ServerException(String msg) {
        this.code = 500;
        this.msg = msg;
    }
}
