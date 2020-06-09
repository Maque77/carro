package com.java4h.ilcarro.common.exceptions;

public class IncorrectLogicException extends RuntimeException {
    public IncorrectLogicException(String message){
        super("An error has occurred. " + message);
    }
}
