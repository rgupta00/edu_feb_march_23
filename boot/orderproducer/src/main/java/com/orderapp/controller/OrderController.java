package com.orderapp.controller;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orderapp.config.MessagingConfig;
import com.orderapp.dto.Order;
import com.orderapp.dto.OrderStatus;

@RestController
public class OrderController {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@PostMapping("/order/{restName}")
	public String bookOrder(@RequestBody Order order, @PathVariable String restName) {
		order.setOrderId(UUID.randomUUID().toString());
		
		System.out.println("----------------------------------");
		//some more processing
		OrderStatus orderStatus=new OrderStatus(order, "PROSSING", "order is obtain successfully!");
		
		rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE_NAME, MessagingConfig.ROUTING_NAME, orderStatus);
		
		return "order is booked";
	}

}
