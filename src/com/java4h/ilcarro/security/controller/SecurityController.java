package com.java4h.ilcarro.security.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.java4h.ilcarro.security.dto.AccountDto;
import com.java4h.ilcarro.security.dto.AuthPair;
import com.java4h.ilcarro.security.services.SecurityService;

@RestController
@RequestMapping("/security")
@CrossOrigin
@Validated
public class SecurityController {
	
	@Autowired SecurityService service;
	
	@PostMapping("/addUser") //create new account
	public AccountDto addUser(@RequestBody @Valid AuthPair authPair) {
		return service.addUser(authPair.getLogin(), authPair.getPassword());
	};

	@PostMapping("/addAccount")
	public AccountDto addAccount(@RequestBody @Valid AuthPair authPair, @RequestParam String role) {
		return service.addAccount(authPair.getLogin(), authPair.getPassword(), role);
	};
	
	@GetMapping("/getAllAccounts")
	public List<AccountDto> getAllAccounts(){
		return service.getAllAccounts();
	};

	@DeleteMapping("/removeAccount")
	public AccountDto removeAccount(String login) {
		return service.removeAccount(login);
	};


		
}
