package com.bankapp.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.bankapp.web.interceptor.HelloInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.bankapp.web.*"})
public class WebConfig implements WebMvcConfigurer{

	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver ir=new InternalResourceViewResolver();
		ir.setPrefix("/WEB-INF/views/");
		ir.setSuffix(".jsp");
		
		return ir;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HelloInterceptor());
	}
	
	
}
