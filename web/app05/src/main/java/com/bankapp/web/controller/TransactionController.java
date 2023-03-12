package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entities.Account;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.dto.TransferDto;

@Controller
public class TransactionController {

	private AccountService accountService;

	@Autowired
	public TransactionController(AccountService accountService) {
		this.accountService = accountService;
	}

	// ----------------add new account object-------------
	@GetMapping(path = "transfer")
	public String transferGet(Model model) {
		model.addAttribute("transferDto", new TransferDto());
		return "fund_transfer";
	}

	// ----------------add new account object-------------
	@PostMapping(path = "transfer")
	public String transferPost(@ModelAttribute(name = "transferDto") TransferDto transferDto) {
		
		accountService.transfer(transferDto.getFromAccountId(), transferDto.getToAccountId(), transferDto.getAmount());
		return "redirect:accounts";
	}

}
