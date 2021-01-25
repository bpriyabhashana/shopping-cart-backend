package com.store.shoppingcart.Enumz;

public enum ResponseMessage {
    SUCCESS("success");

    private final String message;
    ResponseMessage(String message){
        this.message = message;
    }

    public String toString(){
        return this.message;
    }
}
