package com.hoanglong.springbootblogwebapp.init.exception;

import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenExceptionResponse {
    private LocalDate errorDate;
    private String message;
    private String detail;
}
