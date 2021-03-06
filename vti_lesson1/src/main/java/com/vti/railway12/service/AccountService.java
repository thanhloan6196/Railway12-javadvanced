package com.vti.railway12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.railway12.DAO.AccountDAO;
import com.vti.railway12.entity.Account;

@Service
@Transactional
public class AccountService {
	@Autowired
	private AccountDAO accountDAO;
	
	public Account findById(int id) {
		return accountDAO.findById(id);
	}

	public List<Account> findAll() {
		return accountDAO.findAll();
	}
	
	public void save(Account account) {
		accountDAO.save(account);
	}

	public void update(Account account) {
		accountDAO.update(account);;
	}

	public void delete(Account account) {
		accountDAO.delete(account);
	}
}
