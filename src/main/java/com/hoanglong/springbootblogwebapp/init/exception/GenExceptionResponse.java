package com.hoanglong.springbootblogwebapp.init.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
public class GenExceptionResponse {
    private LocalDate errorDate;
    private String message;
    private String detail;
}
