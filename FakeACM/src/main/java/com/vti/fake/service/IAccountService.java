package com.vti.fake.service;

import java.util.List;

import com.vti.fake.entity.Account;
import com.vti.fake.form.FormSearchAccount;

public interface IAccountService {

	List<Account> getAllAccount();
	
	Account findAccountById(Integer id);
	
	void createAccount(Account account);
	
	void updateAccount(Account account);
	
	void deleteAccount(int id);
	
	boolean isAccountExistByEmail(String email);
	
	boolean isAccountExistByUserName(String userName);
	
	List<Account> search(FormSearchAccount account);
	
}
