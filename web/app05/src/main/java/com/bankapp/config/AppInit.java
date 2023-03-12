package com.bankapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.bankapp.model.config.ModelConfig;
import com.bankapp.web.config.WebConfig;

//this is not a compoent
//Servlet 3.0 : pluggablity
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	//RootAppContext
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("------------getRootConfigClasses--------------------");
		return new Class[] {ModelConfig.class};
	}

	//WebAppContext
	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("------------getServletConfigClasses--------------------");
		return new Class[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
