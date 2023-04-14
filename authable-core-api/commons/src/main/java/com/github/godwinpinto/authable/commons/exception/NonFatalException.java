package com.github.godwinpinto.authable.commons.exception;

public class NonFatalException extends Exception {
    private final String errCode;

    public NonFatalException() {
        super();
        this.errCode = "0";
    }

    public NonFatalException(String message) {
        super(message);
        this.errCode = "0";
    }

    public NonFatalException(String errCode, String message) {
        super(message);
        this.errCode = errCode;
    }

    public NonFatalException(String message, Throwable cause) {
        super(message, cause);
        this.errCode = "0";
    }

    public NonFatalException(String errCode, String message, Throwable cause) {
        super(message, cause);
        this.errCode = errCode;
    }

    public String getErrCode() {
        return this.errCode;
    }
}
