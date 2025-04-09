package com.user.platonapi.common.response;

import java.util.List;

public class SuccessResponse<T> {
    private String message;
    private int statusCode;
    private List<T> data;

    public SuccessResponse(String message, int statusCode, List<T> data) {
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }

    public SuccessResponse(String message, int statusCode, T data) {
        this.message = message;
        this.statusCode = statusCode;
        this.data = List.of(data);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
