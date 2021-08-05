package com.vti.railway12.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vti.railway12.entity.Account;
import com.vti.railway12.form.FormSearchAccount;
import com.vti.railway12.repository.IAccountRepository;

@Service
public class AccountServiceImpl implements IAccountService{

	@Autowired
	IAccountRepository accountRepository;
	
	@Value("${account.page.recordTotals}")
    private int totalRecords;

	@Override
	public Page<Account> getAllAccount(int page, String collum) {
		Pageable pageable = PageRequest.of(page, totalRecords, Sort.by(collum).ascending());
		return accountRepository.findAll(pageable);
	}

	@Override
	public Account getAccountById(Long id) {
		// TODO Auto-generated method stub
		return accountRepository.findById(id).get();
	}

	@Override
	public void createAccount(Account account) {
		
		accountRepository.save(account);
	}

	@Override
	public void updateAccount(Account account) {
		Account accountupdate = accountRepository.findById(account.getId()).get();
		accountupdate.setId(account.getId());
		accountupdate.setEmail(account.getEmail());
		accountupdate.setUserName(account.getUserName());
		accountupdate.setFullName(account.getFullName());
		accountupdate.setDepartment(account.getDepartment());
		accountupdate.setPosition(account.getPosition());
		accountRepository.save(accountupdate);
		
	}

	@Override
	public void deleteAccount(Account account) {
		accountRepository.delete(account);
		
	}

	@Override
	public boolean isAccountExistByEmail(String email) {
		List<Account> listAccount = accountRepository.findByEmail(email);
		if( listAccount.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isAccountExistByUserName(String userName) {
		List<Account> listAccount = accountRepository.findByUserName(userName);
		if( listAccount.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Page<Account> search(FormSearchAccount account) {
		Pageable pageable = PageRequest.of(account.getPage(), totalRecords, Sort.by("id"));
		return accountRepository.findAccountByUserNameAndEmailAndFullNameAndPositionAndDepartment(account.getUserName(),
				account.getEmail(), account.getFullName(), account.getPositionID(),
				account.getDepartmentID(), pageable);
	}
}
