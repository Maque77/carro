package com.java4h.ilcarro.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolationException;
import com.java4h.ilcarro.common.exceptions.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.java4h.ilcarro.security.exceptions.AccountManagementException;

@ControllerAdvice
public class CommonControllerAdvice extends ResponseEntityExceptionHandler {

	// Custom errors handling
	@ExceptionHandler(value = {
			IdNotFoundException.class,
			AccountManagementException.class,		// TODO: ? (NO USAGES)
			DataNotFoundException.class,			// bad user request or data deleted
			InvalidValueException.class,			// bad user request
			IncorrectLogicException.class			// bad user request or access rights
	})
	public ResponseEntity<?> handleBadRequest(RuntimeException exception) {
		 return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	// Server-side other errors handling
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<?> handleOthersExceptions(RuntimeException exception) {
		// TODO: change to commented below, exception throws for showing in terminal foe debugging
		throw exception;
//		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);

	}

	// Validation (@Valid) errors handling for all application
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        	MethodArgumentNotValidException exception,
			HttpHeaders headers,
        	HttpStatus status,
			WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();

        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        // TODO: check with Alex how to implement it right!!
//        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errors.get(0), HttpStatus.BAD_REQUEST);
    }

	// Validation (@Validated) errors handling, only for first message
	@ExceptionHandler(value = { ConstraintViolationException.class })
	public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex) {
		ArrayList<String> errors =  new ArrayList<>();
		ex.getConstraintViolations().stream().forEach(cv -> errors.add(cv.getMessage()));
		// TODO: check with Alex how to implement it right!!
//		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(errors.get(0), HttpStatus.BAD_REQUEST);
	}

	// Parsing errors
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException exception,
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request) {
		return new ResponseEntity<>("Input message not readable, JSON parsing error", HttpStatus.BAD_REQUEST);
	}
}
