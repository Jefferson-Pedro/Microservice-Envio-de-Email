package com.ms.email.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		Email email = service.sendEmail(emailDTO);
		return new ResponseEntity<>(email, HttpStatus.CREATED);
	}
	
	@GetMapping("/emails")
	public ResponseEntity<Page<Email>> getAllEmails(@PageableDefault(page = 0, size = 5, sort = "emailId", direction = Sort.Direction.DESC)Pageable pageable){
		
		return new ResponseEntity<>(service.findAll(pageable), HttpStatus.OK);
	}
	
	@GetMapping("/emails/{id}")
	public ResponseEntity<?>getOneEmail(@PathVariable(value = "emailId") UUID emailId){
		Email email = service.findById(emailId);
		if ( email != null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(email);
	}
}
