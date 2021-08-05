package com.vti.fake.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.fake.entity.Account;
import com.vti.fake.service.IAccountService;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AccountController {

	@Autowired
	IAccountService accountService;
	
	@GetMapping("/account-list")
	ResponseEntity<List<Account>> getListAccount(){
		List<Account> listAccount = accountService.getAllAccount();
		return new ResponseEntity<List<Account>>(listAccount, HttpStatus.OK);
	
	}
	
	@GetMapping("/account/{id}")
	ResponseEntity<Account> getAccountById(@PathVariable(name = "id") Integer id){
		
		return new ResponseEntity<Account>(accountService.findAccountById(id), HttpStatus.OK);
			
	}
	
	
	@PostMapping("/create")
	ResponseEntity<?> createAccount(@RequestBody Account account){
		accountService.createAccount(account);
		return ResponseEntity.ok(("Success"));
	}
	
	@PostMapping("/update")
	ResponseEntity<?> updateAccount(@RequestBody Account account){
		accountService.updateAccount(account);
		return ResponseEntity.ok(("Success"));
	}
	
	@PostMapping("/delete/{id}")
	ResponseEntity<?> deleteAccount(@PathVariable(name = "id") int id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok(("Success delete"));
	}
	
}
