package com.hoanglong.springbootblogwebapp.init.exception.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message){
        super(message);
    }
}
