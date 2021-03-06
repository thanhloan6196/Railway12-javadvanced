package com.vti.railway12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.railway12.entity.Account;
import com.vti.railway12.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/account-list")
	public List<Account> getAllAccount() {
		return accountService.findAll();
	}

	@GetMapping("account/{id}")
	public Account getById(@PathVariable int id) {
		return accountService.findById(id);
	}

	@PostMapping("/update")
	public void update(@RequestBody Account account) {
		accountService.update(account);
	}

	@PostMapping("/create")
	public void createAccount(@RequestBody Account account) {
		accountService.save(account);
	}
	
	@PostMapping("/delete")
	public void deleteAccount(@RequestBody Account account) {
		accountService.delete(account);
	}

}
