package com.java4h.ilcarro.common.exceptions;

@SuppressWarnings("serial")
public class DuplicatedIdException extends RuntimeException {
	
	public DuplicatedIdException(String msg) {
		super(msg);
	}
}
