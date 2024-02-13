package com.ms.email.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.email.dtos.EmailDTO;
import com.ms.email.models.Email;
import com.ms.email.repositories.EmailRepository;

@Service
public class EmailService {
	
	@Autowired
	EmailRepository repository;

	public Email sendEmail(EmailDTO emailDTO) {
		
		Email emailModel = new Email();
		BeanUtils.copyProperties(emailDTO, emailModel);
		return repository.save(emailModel);
	}
}
