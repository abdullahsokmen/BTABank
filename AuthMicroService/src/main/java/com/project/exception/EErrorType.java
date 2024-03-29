package com.project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EErrorType {

    INVALID_PARAMETER(1000,"Invalid parameter entered", BAD_REQUEST),
    METHOD_MIS_MATCH_ERROR(1001,"The value you entered does not match the desired value.", BAD_REQUEST),
    METHOD_NOT_VALID_ARGUMENT_ERROR(1002,"Missing parameter submission in URL",BAD_REQUEST),

    INVALID_TOKEN(1004,"Invalid token",HttpStatus.BAD_REQUEST),
    NOT_DECODED(1005,"Token can not decoded", INTERNAL_SERVER_ERROR),
    HTTP_MESSAGE_NOT_READABLE(1006,"Http message not readable",BAD_REQUEST),
    TOKEN_NOT_CREATED(1007,"Token can not be created", INTERNAL_SERVER_ERROR),
    UNEXPECTED_ERROR(1008,"Unexpected Error Occured", INTERNAL_SERVER_ERROR),
    USER_NOT_FOUND(1008,"User not found", INTERNAL_SERVER_ERROR),


    EMAIL_ALREADY_TAKEN(3000,"Email already taken", BAD_REQUEST),
    USER_NOT_ACTIVE(1105,"User not active", BAD_REQUEST),
    PERSONAL_NOT_EXIST(1105,"Personal not exist", BAD_REQUEST),
    LOGIN_ERROR_USERNAME_PASSWORD(1102,"Username or Password are incorrect", BAD_REQUEST),



            ;


    private int code;
    private String message;
    private HttpStatus httpStatus;
}
