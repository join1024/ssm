package com.join.learn.ssm.exception;

public class SsmException extends RuntimeException{

    public SsmException() {
    }

    public SsmException(String message) {
        super(message);
    }

    public SsmException(String message, Throwable cause) {
        super(message, cause);
    }

    public SsmException(Throwable cause) {
        super(cause);
    }
}
