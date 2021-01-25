package com.store.shoppingcart.Response;

import com.store.shoppingcart.Enumz.ResponseMessage;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class Response {
    private String message;
    private Object data;
    private HttpStatus status;
    private String timestamp;

    public Response(ResponseMessage message, HttpStatus status, Object data) {
        this.message = message.toString();
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getTimestamp() {
        return (new Date()).toString();
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}