package com.project.exception;

import lombok.Getter;

@Getter
public class PaymentServiceException extends RuntimeException{
    private final EErrorType errorType;

    public PaymentServiceException(EErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public PaymentServiceException(EErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}
