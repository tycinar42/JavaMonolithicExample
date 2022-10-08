package com.tyc.JavaMonolithicExample.exception;

import lombok.Getter;

@Getter
public class MonolithicManagerException extends RuntimeException{

    private final EErrorType errorType;

    public MonolithicManagerException(EErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public MonolithicManagerException(EErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType = errorType;
    }

}
