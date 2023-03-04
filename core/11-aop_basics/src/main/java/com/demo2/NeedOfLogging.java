package com.demo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NeedOfLogging {

	private static Logger logger=LoggerFactory.getLogger(NeedOfLogging.class);
			
			
	public static void main(String[] args) {
		
		//logging facade		
		
		//SLF4J-----------------> Log4j2	LogBack		 comonLogging
		
		
		System.out.println("---code is working till line no 6----");
		logger.info("---code is working till line no 6----");
		
		
		
		
		System.out.println("---code is working till line no 12----");
		logger.info("---code is working till line no 12----");
		
		
		
		
		
		
		
		
		
		
		System.out.println("---code is working till line no 37----");
		logger.info("---code is working till line no 37----");
	}
}
