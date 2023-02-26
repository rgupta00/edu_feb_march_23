package com.demo1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BPP1 implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		//used to customised bean itself
		System.out.println("---------postProcessBeforeInitialization--------");
		
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("---------postProcessAfterInitialization--------");
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

}
