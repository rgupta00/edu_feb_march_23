package com.productapp.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MySQLTypeCondition implements Condition{
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String dbType= System.getProperty("dbType");
		return dbType.equalsIgnoreCase("MYSQL");
	}

}
