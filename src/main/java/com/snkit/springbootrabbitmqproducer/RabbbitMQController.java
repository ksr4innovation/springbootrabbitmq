package com.snkit.springbootrabbitmqproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbbitMQController {
	
	@Autowired
	RabbitMQProducer rabbitMQProducer;	
	

	public RabbitMQProducer getRabbitMQProducer() {
		return rabbitMQProducer;
	}

	public void setRabbitMQProducer(RabbitMQProducer rabbitMQProducer) {
		this.rabbitMQProducer = rabbitMQProducer;
	}

	@PostMapping(value="/postMsgExistExchange")
	public String postMsgExistExchange(@RequestBody User msg) {
		
		rabbitMQProducer.postMsgExistExchange(msg);
		
		return "Message sent to sendMsgExistExchangeOnServer successfully";
	}
	
	@PostMapping(value="/postMsgNewExchangeFromApp")
	public String postMsgNewExchangeFromApp(@RequestBody User msg) {
		
		rabbitMQProducer.sendMessage(msg);
		
		return "Message sent to sendMsgNewExchangeOnServer successfully";
	}
	
}
