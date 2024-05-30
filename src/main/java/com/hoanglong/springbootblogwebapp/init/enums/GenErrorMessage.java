package com.hoanglong.springbootblogwebapp.init.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GenErrorMessage {
    ITEM_NOT_FOUND("Item not found!","Please check the id of the item."),
    VALUE_CANNOT_BE_NEGATIVE("Value cannot be negative!","Please enter a value that is zero or larger."),
    PARAMETER_CANNOT_BE_NULL("Parameter cannot be null","Please enter a parameter."),
    ;

    private final String message;
    private final String detailMessage;

}
