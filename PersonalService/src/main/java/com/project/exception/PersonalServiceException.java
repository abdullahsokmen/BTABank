package com.project.exception;

import lombok.Getter;

@Getter
public class PersonalServiceException extends RuntimeException{
    private final EErrorType errorType;

    public PersonalServiceException(EErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public PersonalServiceException(EErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}
