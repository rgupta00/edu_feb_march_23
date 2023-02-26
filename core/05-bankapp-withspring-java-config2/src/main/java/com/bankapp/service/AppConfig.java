package com.bankapp.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = {"com.bankapp.service"})
public class AppConfig {
	
	//@Compnent family vs @Bean *
	@Bean(name = { "accService","accServiceV2"})
	public AccountService accountService(MessingService messingService) {
		System.out.println("it is called accountService()");
		AccountService accountService=new AccountService();
		accountService.setMessingService(messingService);
		return accountService;
	}
	
	@Bean
	public MessingService messingServiceSms() {
		return new SmsService();
	}
	
	@Primary
	@Bean
	public MessingService messingServiceEmail() {
		return new EmailService();
	}

}
