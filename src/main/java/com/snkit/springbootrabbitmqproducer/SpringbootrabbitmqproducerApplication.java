package com.snkit.springbootrabbitmqproducer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootrabbitmqproducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootrabbitmqproducerApplication.class, args);
	}
	
	@Bean
	public Jackson2JsonMessageConverter jsonMessageConverter() {
	    Jackson2JsonMessageConverter jsonConverter = new Jackson2JsonMessageConverter();
	    jsonConverter.setClassMapper(classMapper());
	    return jsonConverter;
	}
	@Bean
	public DefaultClassMapper classMapper() {
	    DefaultClassMapper classMapper = new DefaultClassMapper();
	    Map<String, Class<?>> idClassMapping = new HashMap<>();
	    idClassMapping.put("user", User.class);
	    classMapper.setIdClassMapping(idClassMapping);
	    return classMapper;
	}
	@Bean
	AmqpTemplate  amqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate amqpTemplate= new RabbitTemplate(connectionFactory);
		
		amqpTemplate.setMessageConverter(jsonMessageConverter());
		
		return amqpTemplate;
		
	}
}
