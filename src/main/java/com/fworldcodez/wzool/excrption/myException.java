package com.fworldcodez.wzool.excrption;

public class myException extends  Exception {
    private static final long serialVersionUID = 1L;
    //异常信息
    private String message;

    public myException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
