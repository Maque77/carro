package com.java4h.ilcarro.security.services;

import java.util.List;
import java.util.Set;

import com.java4h.ilcarro.security.dto.AccountDto;
import com.java4h.ilcarro.security.entities.Account;
import com.java4h.ilcarro.security.repositories.AccountMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


@Transactional
@Service
public class SecurityServiceImpl implements SecurityService {
	
	@Autowired
	AccountMongoRepository accountRepo;
	@Autowired DtoServiceImpl dtoService;
	@Autowired PasswordEncoder encoder;

	private Account getAccount(String login) {
		return accountRepo.checkById(login, true);
	}

	@Override // why commented?
	public AccountDto addUser(String login, String password) {
		accountRepo.checkById(login, false);	
		Account account = new Account(login, encoder.encode(password), "ROLE_USER");
		accountRepo.save(account);
		return dtoService.accountDto(account);
	}
	
	@Override
	public AccountDto addAccount(String login, String password, String role) {
		
		accountRepo.checkById(login, false);			
		Account account = new Account(login, encoder.encode(password), "ROLE_"+role);
		accountRepo.save(account);
		return dtoService.accountDto(account);			
		
	}
	
	
	@Override
	public List<AccountDto> getAllAccounts() {
		return dtoService.accountDtoList(accountRepo.findAll());
	}

	@Override
	public AccountDto removeAccount(String login) {
		Account account = getAccount(login);
		accountRepo.deleteById(login);
		return dtoService.accountDto(account);
	}
	
	
}
