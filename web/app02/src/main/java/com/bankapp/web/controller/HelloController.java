package com.bankapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
//Back controller
@Controller
public class HelloController {

	
	@GetMapping(path = "hellourl")
	public ModelAndView hello(ModelAndView mv) {
		mv.addObject("key", "spring mvc champs");//http req scope
		mv.setViewName("mypage");//logical jsp name
		return mv;
	}
}
