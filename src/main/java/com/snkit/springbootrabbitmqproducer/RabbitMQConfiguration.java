package com.snkit.springbootrabbitmqproducer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfiguration {
	
	@Value("${snkit.exchange}")
	private String exchange;
	
	@Value("${snkit.demoexchange.routekey}")
	private String routekey;
	
	@Value("${snkit.demoexchange.queue}")
	private String queuename;
	
	private String appInputExchange = "spring-boot-exchange";
	private String appDirectExchangeRouteKey = "sample.key";
	
	 @Bean
	    Exchange exchange() {
	        return new DirectExchange(appInputExchange);
	    }
	 @Bean
	    Queue queue() {
	        return new Queue("microservicedemoforcustomqueue", true);
	    }

	 @Bean
	    Binding binding(Queue queue, DirectExchange exchange) {
	        return BindingBuilder.bind(queue).to(exchange).with(appDirectExchangeRouteKey);
	    }
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getRoutekey() {
		return routekey;
	}
	public void setRoutekey(String routekey) {
		this.routekey = routekey;
	}
	public String getQueuename() {
		return queuename;
	}
	public void setQueuename(String queuename) {
		this.queuename = queuename;
	}
	public String getAppInputExchange() {
		return appInputExchange;
	}
	public void setAppInputExchange(String appInputExchange) {
		this.appInputExchange = appInputExchange;
	}
	public String getAppDirectExchangeRouteKey() {
		return appDirectExchangeRouteKey;
	}
	public void setAppDirectExchangeRouteKey(String appDirectExchangeRouteKey) {
		this.appDirectExchangeRouteKey = appDirectExchangeRouteKey;
	}
	 
	 
	 
}
