package com.ms.email.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ms.email.dtos.EmailDTO;
import com.ms.email.models.Email;
import com.ms.email.services.EmailService;

@Component
public class EmailConsumer {

	@Autowired
	EmailService service;
	
	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void listen(@Payload EmailDTO emailDTO) {
		
		Email emailModel = service.sendEmail(emailDTO);
		System.out.println("Email Status: " + emailModel.getStatusEmail().toString());
	}
}
