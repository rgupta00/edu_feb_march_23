package com.bankapp.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * <context:annotation-config />	<!-- hey spring i will go with annotation -->
	<context:component-scan
		base-package="com.bankapp.service" /> <!-- hey spring go inside this package (nested too) and look for @Compoents 
		...and configure then -->
 */

//java config mean No XML while config spring bean wiring
@Configuration
@ComponentScan(basePackages = {"com.bankapp.service"})
public class AppConfig {

}
