package com.java4h.ilcarro.common.exceptions;

public class ServerErrorException extends Exception {
    public ServerErrorException(String e){
        super("Something went really wrong");
    }
}
