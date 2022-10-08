package com.tyc.JavaMonolithicExample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.ok("An unexpected error has occurred: " + ex.getMessage());
    }


    @ExceptionHandler(MonolithicManagerException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleCommentAppManagerException(MonolithicManagerException ex){
        EErrorType errorType = ex.getErrorType();
        HttpStatus httpStatus = errorType.getHttpStatus();
        /**
         * ResponseEntity.ok().build(); // 200
         */
        return new ResponseEntity<>(createError(errorType,ex),httpStatus);
    }


    private ErrorMessage createError(EErrorType errorType, Exception exception){
        System.out.println("Error has occurred: " + exception.getMessage());
        return ErrorMessage.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .build();
    }
}
