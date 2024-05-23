package com.hoanglong.springbootblogwebapp.init.exception.exceptions;

import com.hoanglong.springbootblogwebapp.init.enums.IBaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalFieldException extends GenBusinessException{
    public  IllegalFieldException(IBaseErrorMessage message){
        super(message);
    }
}
