package com.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

@Component(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Bar {

	private String time = LocalDateTime.now().toString();

	public Bar() {
		System.out.println("ctr of bar is called");
	}

	public String getTime() {
		return time;
	}
	
}
