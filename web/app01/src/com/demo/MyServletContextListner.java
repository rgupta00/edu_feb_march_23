package com.demo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class MyServletContextListner
 *
 */
public class MyServletContextListner implements ServletContextListener {

	//u can keep some db connection in the context scope and any servlet can pick it
  
    public MyServletContextListner() {
    
    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
       System.out.println("-----------contextDestroyed---is called----");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("--------contextInitialized ---------is called");
    }
	
}
