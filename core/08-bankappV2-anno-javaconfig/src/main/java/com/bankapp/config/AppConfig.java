package com.bankapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//<context:annotation-config/>
//<context:component-scan base-package="com.bankapp.*"/>
@ComponentScan(basePackages = "com.bankapp.*")
@Configuration
public class AppConfig {

}
