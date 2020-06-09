package com.java4h.ilcarro.security.repositories;

import com.java4h.ilcarro.common.CustomizedMongoRepository;
import com.java4h.ilcarro.security.entities.Account;

public interface AccountMongoRepository extends CustomizedMongoRepository<Account, String> {
	default String type() {
		return "Account";
	}

}
