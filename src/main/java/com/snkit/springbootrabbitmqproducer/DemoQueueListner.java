package com.snkit.springbootrabbitmqproducer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoQueueListner {
	
	@Autowired
	UserRepository userRepository;
	
	@RabbitListener(queues="demotestqueue")
	public void readMessage(User message) {
		
		
		System.out.println("  Demo Queu listener   "+message);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserEntity  userEntity = new UserEntity();
		userEntity.setCountry(message.getCountry());
		
		userEntity.setDesg(message.getDesg());
		userEntity.setEmail(message.getEmail());
		userEntity.setName(message.getName());
		userEntity.setState(message.getState());
		
		
		userRepository.save(userEntity);
		
	}
}
