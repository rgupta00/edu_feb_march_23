package com.orderapp.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

	public final static String QUE_NAME = "javademo_queue";
	public final static String EXCHANGE_NAME = "javademo_exchange";
	public final static String ROUTING_NAME = "javademo_routingkey";

	// que
	@Bean
	public Queue queue() {
		return new Queue(QUE_NAME);
	}

	// exchange
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange("javademo_exchange");
	}

	@Bean
	public Binding Binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("javademo_routingkey");
	}

	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}
	// binding
}




