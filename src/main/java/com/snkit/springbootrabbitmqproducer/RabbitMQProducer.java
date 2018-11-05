package com.snkit.springbootrabbitmqproducer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {
	
	
	
	@Autowired
	private AmqpTemplate  amqpTemplate ;
	
	@Autowired
	RabbitMQConfiguration rabbitMQConfiguration;
	
	public void sendMessage(User msg) {		
		amqpTemplate.convertAndSend(rabbitMQConfiguration.getAppInputExchange(),
				rabbitMQConfiguration.getAppDirectExchangeRouteKey(), msg);
	}
	
	public void postMsgExistExchange(User msg) {		
		amqpTemplate.convertAndSend(rabbitMQConfiguration.getExchange(),
				rabbitMQConfiguration.getRoutekey(), msg);
	}

}
