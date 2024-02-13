package com.ms.email.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.email.models.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {

}
