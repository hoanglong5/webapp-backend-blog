package com.hoanglong.springbootblogwebapp.init.exception;

import com.hoanglong.springbootblogwebapp.init.controller.RestResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@RestController
@RestControllerAdvice
public class GenCustomResponseException {
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<Object> HandlerAllException(Exception ex, WebRequest webRequest){
        LocalDate dateError = LocalDate.now();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);
        GenExceptionResponse genExceptionResponse = new GenExceptionResponse(dateError,message,description);
        RestResponse<GenExceptionResponse> response = RestResponse.error(genExceptionResponse);
        response.setMessage(message);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

