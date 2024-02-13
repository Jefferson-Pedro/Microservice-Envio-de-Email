package com.ms.email.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmailDTO {
	
	@NotBlank
	private String ownerRef;
	
	@Email
	@NotBlank
	@NotNull
	private String emailFrom;
	
	@Email
	@NotBlank
	@NotNull
	private String emailTo;
	
	@NotBlank
	@NotNull
	private String subject;
	
	@NotBlank
	@NotNull
	private String text;
	
	//GET E SET

	public String getOwnerRef() {
		return ownerRef;
	}

	public void setOwnerRef(String ownerRef) {
		this.ownerRef = ownerRef;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "EmailDTO [ownerRef=" + ownerRef + ", emailFrom=" + emailFrom + ", emailTo=" + emailTo + ", subject="
				+ subject + ", text=" + text + "]";
	}
}
