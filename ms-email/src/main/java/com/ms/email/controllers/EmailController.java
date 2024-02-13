package com.ms.email.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.email.dtos.EmailDTO;
import com.ms.email.models.Email;
import com.ms.email.services.EmailService;

import jakarta.validation.Valid;

@RestController
public class EmailController {
	
	@Autowired
	EmailService service;
	
	@PostMapping("/sending-email")
	public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDTO emailDTO){
		
		Email emailModel = service.sendEmail(emailDTO);
		if (emailModel != null) {
			return ResponseEntity.ok(emailModel);
		}
		return ResponseEntity.badRequest().build();
	}
	
}
