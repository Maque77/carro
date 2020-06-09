package com.java4h.ilcarro.common.exceptions;

/**
 * Changed to IdNotFoundException and has to be deleted
 */
// TODO: DELETE
@Deprecated
public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String message){
        super("Requested data not found. " + message);
    }
}
