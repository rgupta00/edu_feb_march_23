package com.orderapp.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.orderapp.config.MessagingConfig;
import com.orderapp.dto.OrderStatus;

@Service
public class OrderConsumer {
	
	@RabbitListener(queues = MessagingConfig.QUE_NAME)
	public void consumerFormQueue(OrderStatus orderStatus) {
		System.out.println("-------------------");
		System.out.println(orderStatus);
	}

}
