package com.project.exception;

import lombok.Getter;

@Getter
public class CustomerServiceException extends RuntimeException{
    private final EErrorType errorType;

    public CustomerServiceException(EErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public CustomerServiceException(EErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}
