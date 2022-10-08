package com.tyc.JavaMonolithicExample.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.*;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum EErrorType {

    USER_NOT_FOUND(1000,"User could not found",INTERNAL_SERVER_ERROR),
    USER_NOT_CREATED(1001,"User could not be registered",INTERNAL_SERVER_ERROR),
    PRODUCT_NOT_FOUND(2000,"Product could not found",INTERNAL_SERVER_ERROR),
    PRODUCT_NOT_CREATED(2001,"Product could not be registered",INTERNAL_SERVER_ERROR),
    CATEGORY_NOT_FOUND(3001,"Category could not found",INTERNAL_SERVER_ERROR),
    CATEGORY_NOT_CREATED(3002,"Category could not be registered",INTERNAL_SERVER_ERROR);
    private int code;
    private String message;
    HttpStatus httpStatus;
}
