package com.ms.email.services;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms.email.dtos.EmailDTO;
import com.ms.email.enums.StatusEmail;
import com.ms.email.models.Email;
import com.ms.email.repositories.EmailRepository;

@Service
public class EmailService {
	
	@Autowired
	EmailRepository repository;
	
	@Autowired
	private JavaMailSender eMailSender;

	public Email sendEmail(EmailDTO emailDTO) {
		
		Email email = convertDTOToEmail(emailDTO);
		
		email.setSendDateEmaiL(LocalDateTime.now());
		
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(email.getEmailFrom());
			message.setTo(email.getEmailTo());
			message.setSubject(email.getSubject());
			message.setText(email.getText());
			eMailSender.send(message);
			
			email.setStatusEmail(StatusEmail.SENT);
		} catch (MailException e) {
			System.err.println(e.getMessage());
			email.setStatusEmail(StatusEmail.ERROR);
			
		}finally {
			return repository.save(email);
		}
	}
	
	private Email convertDTOToEmail(EmailDTO emailDTO) {
		
		Email emailModel = new Email();
		BeanUtils.copyProperties(emailDTO, emailModel);
		
		return emailModel;
	}
}
