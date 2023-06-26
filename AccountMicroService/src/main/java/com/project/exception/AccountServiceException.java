package com.project.exception;

import lombok.Getter;

@Getter
public class AccountServiceException extends RuntimeException{
    private final EErrorType errorType;

    public AccountServiceException(EErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public AccountServiceException(EErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}
