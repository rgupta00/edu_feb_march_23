package com.bankapp.restcontroller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping(path = "api")
public class AccountRestController {
	
	private final AccountService accountService;

	//---------getting all accounts--------------
	
	@GetMapping(path = "accounts")
	public List<Account> getAll(){
		return accountService.getAll();
	}
	
	//---------getting an specific accounts--------------
	//@PathVariable vs @RequestParam
	
	@GetMapping(path = "accounts/{aid}")
	public Account getAnAccount(@PathVariable(name="aid") int id){
		return accountService.getById(id);
	}
	
	//--------add account--------------
	//@RequestBody force json ie is comming from UI or post man to be converted to json
	
	@PostMapping(path = "accounts")
	public ResponseEntity<Account> addAccount(@RequestBody  Account account){
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.addAccount(account));
	}

	
	//--------deleted account--------------
	@DeleteMapping(path = "accounts/{aid}")
	public ResponseEntity<Void> deleteAnAccount(@PathVariable(name="aid") int id){
		 accountService.deleteAccount(id);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	//--------updated account--------------
	
	@PutMapping(path = "accounts/{aid}")
	public Account updateAnAccount(@PathVariable(name="aid") int id,@RequestBody Account account){
		return accountService.updateAccount(id, account);
	}

}
