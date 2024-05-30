package com.hoanglong.springbootblogwebapp.init.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MessageResponse {
    SUCCESSFULLY_CREATED("Successfully created","message for create"),
    SUCCESSFULLY_DELETE("Successfully deleted","message for delete"),
    SUCCESSFULLY_UPDATED("Successfully updated","message for delete"),
    SUCCESSFULLY_FINDALL("Successfully find all","message for find all"),
    SUCCESSFULLY_FINDBYID("Successfully find by id","message for find by id");

    private String message;
    private String messageDetail;
}
