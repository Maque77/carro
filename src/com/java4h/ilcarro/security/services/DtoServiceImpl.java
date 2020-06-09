package com.java4h.ilcarro.security.services;

import java.util.List;
import java.util.stream.Collectors;

import com.java4h.ilcarro.security.dto.AccountDto;
import com.java4h.ilcarro.security.entities.Account;
import org.springframework.stereotype.Service;


@Service
public class DtoServiceImpl {
	
	public AccountDto accountDto(Account account) {
		return new AccountDto(account.getLogin(), account.getRoles());
	}
	
	public List<AccountDto> accountDtoList(List<Account> accountList) {
		return accountList.stream().map(account -> accountDto(account)).collect(Collectors.toList());
	}
}
