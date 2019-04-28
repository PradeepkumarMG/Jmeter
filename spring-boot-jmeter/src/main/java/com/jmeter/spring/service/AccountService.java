package com.jmeter.spring.service;

import com.jmeter.spring.entity.Account;

public interface AccountService {
	Account findByUsername(String username);
	Account save(Account accout);
}
