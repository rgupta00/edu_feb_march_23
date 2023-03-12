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

@Controller
public class AccountController {

	private AccountService accountService;

	// @PostConstruct
	public void before() {
		accountService.addAccount(new Account("ravi", 4000.00, "ravi@gmail.com", "6644565220"));
		accountService.addAccount(new Account("umesh", 4000.00, "umesh@gmail.com", "6644565220"));
	}

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	// ----------------get all accounts objects-------------
	@GetMapping(path = "accounts")
	public ModelAndView hello(ModelAndView mv) {
		mv.addObject("accounts", accountService.getAll());// http req scope
		mv.setViewName("accounts_info");// logical jsp name
		return mv;
	}

	// ----------------add new account object-------------
	@GetMapping(path = "addaccount")
	public String addaccountGet(Model model) {
		model.addAttribute("account", new Account());
		return "add_account";
	}

	// ----------------add new account object-------------
	@PostMapping(path = "addaccount")
	public String addaccountPost(@ModelAttribute(name = "account") Account account) {
		// validation
		int id=account.getId();
		//if id==0 then it must be new account otherwise it for update
		if (id == 0) {
		accountService.addAccount(account);
		}else {
			accountService.update(account);
		}
		return "redirect:accounts";// application of prg design pattern, double form submission problem
	}

	// ----------------delete an account -------------
	@GetMapping(path = "delete")
	public String deleteAccount(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id").trim());
		accountService.deleteAccount(id);
		return "redirect:accounts";
	}
	//accounts?id=2
	// ----------------update an account ---@Pathvariable vs @requestParam----------
	@GetMapping(path = "update")
	public String updateAccountGet(@RequestParam(name = "id") int id, Model model) {
		model.addAttribute("account",accountService.getById(id) );
		return "update_account";
	}
	

}











