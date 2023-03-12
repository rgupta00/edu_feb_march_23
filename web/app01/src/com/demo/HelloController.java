package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HelloController() { 
    	System.out.println("it is the ctr of servlet");
    }

	@Override
	public void init() throws ServletException {
		System.out.println("it is init method");
	}

	//doGet vs doPost vs http protocol
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("it is the doGet method");
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		out.print("hello to all champs from a servlet");
	}

	@Override
	public void destroy() {
		System.out.println("it is destroy method");
	}


}
