package com.bankapp.restcontroller;
import java.util.List;

import org.springframework.core.env.Environment;
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

import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/transactions")
public class TransactionRestController {
	
	private final AccountService accountService;
	
	private final Environment env;

	//---------fund transfer --------------
	
	@PostMapping(path = "transfer")
	public String transfer(@RequestBody  TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccId(), transferDto.getToAccId(), transferDto.getAmount());
		return env.getProperty("SERVICE.FUNDTRANSFER_SUCCESS");
	}
	
	//---------deposit transfer --------------
	@PostMapping(path = "deposit")
	public String deposit(@RequestBody  DepositDto depositDto) {
		accountService.deposit(depositDto.getId(), depositDto.getAmount());
		return "fund deposit successfully";
	}
	
	//---------withdraw transfer --------------
	
	@PostMapping(path = "withdraw")
	public String withdraw(@RequestBody  WithdrawDto withdrawDto) {
		accountService.withdraw(withdrawDto.getId(), withdrawDto.getAmount());
		return "fund withdrawn successfully";
	}
	
	
	

}
