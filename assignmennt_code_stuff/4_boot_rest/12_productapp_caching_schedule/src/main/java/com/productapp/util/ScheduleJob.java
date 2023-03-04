package com.productapp.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.productapp.entity.Product;
import com.productapp.service.ProductService;

@Service
public class ScheduleJob {
	
	private Logger logger = LoggerFactory.getLogger(ScheduleJob.class);
	
	@Autowired
	private ProductService service;
	
	@Scheduled(initialDelay = 5000, fixedRate = 15000)
	public void fixedRateJob() {
		logger.info("> fixedRateJob");

		// Add scheduled logic here

		List<Product> products = service.getAll();
		
		logger.info("There are {} books in the data store.", products.size());

		logger.info("< fixedRateJob");
	}
}
