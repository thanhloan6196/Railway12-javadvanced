package com.vti.railway12.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.vti.railway12.entity.Account;
import com.vti.railway12.form.FormSearchAccount;

public interface IAccountService {

	Page<Account> getAllAccount(int page, String collum);
	
	Account getAccountById(Long id);
	
	void createAccount(Account account);
	
	void updateAccount(Account account);
	
	void deleteAccount(Account account);
	
	boolean isAccountExistByEmail(String email);
	
	boolean isAccountExistByUserName(String userName);
	
	Page<Account> search(FormSearchAccount account);
}
