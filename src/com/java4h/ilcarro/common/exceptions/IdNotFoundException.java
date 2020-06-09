package com.java4h.ilcarro.common.exceptions;

@SuppressWarnings("serial")
public class IdNotFoundException extends RuntimeException {

	public IdNotFoundException (String msg) {
		super(msg);
	}
}
