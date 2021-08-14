package com.vti.railway12.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.railway12.entity.Account;
import com.vti.railway12.form.FormSearchAccount;
import com.vti.railway12.service.IAccountService;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountController {

	@Autowired
	IAccountService accountService;
	
	private static Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@GetMapping("/account-list")
	@PreAuthorize("hasRole('USER') or hasRole('VTI') or hasRole('ADMIN')")
	ResponseEntity<Page<Account>> getListAccount(@RequestParam int page, @RequestParam String collum) {
		Page<Account> listAccount = accountService.getAllAccount(page, collum);
		
		List<Account> accounts = listAccount.getContent();
		for (Account account : accounts) {
			logger.info("Thông tin account page " + page + ": " + account.toString());
		}
		return new ResponseEntity<Page<Account>>(listAccount, HttpStatus.OK);
	}
	
	
	@GetMapping("/get-account")
	@PreAuthorize("hasRole('USER') or hasRole('VTI') or hasRole('ADMIN')")
	ResponseEntity<Account> getAccount(@RequestParam Long id){
		
		Account account = accountService.getAccountById(id);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	
	@PostMapping("/create")
	@PreAuthorize("hasRole('USER') or hasRole('VTI') or hasRole('ADMIN')")
    public ResponseEntity<?> createAccount(@RequestBody @Valid Account account, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()) {
			throw new Exception(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		
		boolean isExistEmail = accountService.isAccountExistByEmail(account.getEmail());
		if(isExistEmail) {
			return ResponseEntity.ok(("EMAIL"));
		}
		
		boolean isExistUserName = accountService.isAccountExistByUserName(account.getUserName());
		if(isExistUserName) {
			return ResponseEntity.ok(("USERNAME"));
		}
		
		accountService.createAccount(account);
        return ResponseEntity.ok(("Them moi thanh cong acount " + account.getFullName()));
    }
	
	@PostMapping("/update")
	@PreAuthorize("hasRole('USER') or hasRole('VTI') or hasRole('ADMIN')")
    public ResponseEntity<?> updateAccount(@RequestBody @Valid Account account,BindingResult bindingResult ) throws Exception {
		if(bindingResult.hasErrors()) {
			throw new Exception(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		Account accountUpdate = accountService.getAccountById(account.getId());
		if(!accountUpdate.getEmail().equals(account.getEmail())) {
			boolean isExistEmail = accountService.isAccountExistByEmail(account.getEmail());
			if(isExistEmail) {
				return ResponseEntity.ok(("EMAIL"));
			}
		}
		if(!accountUpdate.getUserName().equals(account.getUserName())) {
			boolean isExistUserName = accountService.isAccountExistByUserName(account.getUserName());
			if(isExistUserName) {
				return ResponseEntity.ok(("USERNAME"));
			}
		}
		
			
		accountService.updateAccount(account);
        return ResponseEntity.ok(("Sua thanh cong account " + account.getFullName()));
    }	
	
	@PostMapping("/delete")
	@PreAuthorize("hasRole('USER') or hasRole('VTI') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteAccount(@RequestBody Account account) {
		String fullName = accountService.getAccountById(account.getId()).getFullName();
		accountService.deleteAccount(account);
        return ResponseEntity.ok(("Xoa thanh cong account "+ fullName ));
    }
	
	@PostMapping("/search")
	@PreAuthorize("hasRole('USER') or hasRole('VTI') or hasRole('ADMIN')")
	public ResponseEntity<?> searchAccount(@RequestBody FormSearchAccount account) {
		Page<Account> listAccount = accountService.search(account);
		return new ResponseEntity<Page<Account>>(listAccount, HttpStatus.OK);
	}
	
}
