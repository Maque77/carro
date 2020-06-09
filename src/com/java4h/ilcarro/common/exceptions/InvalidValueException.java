package com.java4h.ilcarro.common.exceptions;

public class InvalidValueException extends RuntimeException {
    public InvalidValueException(String message){
        super("Invalid input. " + message);
    }
}
