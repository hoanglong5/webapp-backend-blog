package com.hoanglong.springbootblogwebapp.init.controller;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestResponse<T> implements Serializable {
    private T data;
    private boolean isSuccess;
    private LocalDate responseDate;
    private String message;
    public RestResponse(T data,boolean isSuccess){
        this.data = data;
        this.isSuccess = isSuccess;
        responseDate = LocalDate.now();
    }

    public static <T> RestResponse<T> of(T t){
        return new RestResponse<>(t,true);
    }
    public static <T> RestResponse<T> error(T t){
        return new RestResponse<>(t,false);
    }
    public static <T> RestResponse<T> empty(){
        return new RestResponse<>(null,true);
    }
}
