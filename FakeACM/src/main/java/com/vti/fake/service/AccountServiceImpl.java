package com.vti.fake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.fake.entity.Account;
import com.vti.fake.form.FormSearchAccount;
import com.vti.fake.repository.IAccountRepository;

@Service
public class AccountServiceImpl implements IAccountService{

	@Autowired
	IAccountRepository accountRepository;
	
	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public Account findAccountById(Integer id) {
		// TODO Auto-generated method stub
		return accountRepository.findById(id).get();
	}

	@Override
	public void createAccount(Account account) {
		accountRepository.save(account);
		
	}

	@Override
	public void updateAccount(Account account) {
		accountRepository.save(account);
		// ******************************
	}

	@Override
	public void deleteAccount(int id) {
		accountRepository.deleteById(id);
		
	}

	@Override
	public boolean isAccountExistByEmail(String email) {
		List<Account> listAccount = accountRepository.findByEmail(email);
		if(listAccount.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isAccountExistByUserName(String userName) {
		List<Account> listAccount = accountRepository.findByUserName(userName);
		if(listAccount.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Account> search(FormSearchAccount account) {
		// TODO Auto-generated method stub
		return accountRepository.findAccounyByUserNameAndFullNameAndEmailAndDepartmentAndPosition(
				account.getUserName(), 
				account.getFullName(), 
				account.getEmail(), 
				account.getDepartmentId(), 
				account.getPositionId());
	}

}
