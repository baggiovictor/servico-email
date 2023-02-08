package com.baggiovictor.email.services;

import com.baggiovictor.email.models.EmailModel;
import com.baggiovictor.email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	EmailRepository repository;

	public void sendEmail(EmailModel email) {

	}
}
