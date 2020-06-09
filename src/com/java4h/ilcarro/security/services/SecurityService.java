package com.java4h.ilcarro.security.services;

import com.java4h.ilcarro.security.dto.AccountDto;

import java.util.List;

public interface SecurityService {

	AccountDto addUser(String login, String password);

	AccountDto addAccount(String login, String password, String role);

	List<AccountDto> getAllAccounts();
	
	AccountDto removeAccount(String login);

}