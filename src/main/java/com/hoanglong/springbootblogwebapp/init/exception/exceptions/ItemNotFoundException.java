package com.hoanglong.springbootblogwebapp.init.exception.exceptions;

import com.hoanglong.springbootblogwebapp.init.enums.IBaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends GenBusinessException {
    public ItemNotFoundException(IBaseErrorMessage message){
        super(message);
    }
}
