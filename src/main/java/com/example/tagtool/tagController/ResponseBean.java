package com.example.tagtool.tagController;

public class ResponseBean {
    //	返回信息
    private String message;
    private Object data;

    public ResponseBean() {

    }

    public ResponseBean(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
