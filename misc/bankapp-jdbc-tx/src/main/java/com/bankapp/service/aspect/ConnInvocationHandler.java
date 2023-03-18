package com.bankapp.service.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class ConnInvocationHandler implements InvocationHandler {
	private Connection connection;
	public ConnInvocationHandler(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().contains("commit") || method.getName().contains("rollback")
				|| method.getName().contains("close"))
			System.out.println("connetion trace: " + method.toGenericString());
		
		Object returnValue = method.invoke(connection, args);

		return returnValue;
	}
}
