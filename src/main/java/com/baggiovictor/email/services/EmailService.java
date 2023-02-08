package com.baggiovictor.email.services;

import com.baggiovictor.email.enums.StatusEmail;
import com.baggiovictor.email.models.EmailModel;
import com.baggiovictor.email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

	@Autowired
	EmailRepository repository;


	@Autowired
	private JavaMailSender emailSender;

	public EmailModel sendEmail(EmailModel email) {
		email.setSendDateEmail(LocalDateTime.now());
		try{
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(email.getEmailFrom());
			message.setTo(email.getEmailTo());
			message.setSubject(email.getSubject());
			message.setText(email.getText());
			emailSender.send(message);

			email.setStatusEmail(StatusEmail.SENT);
		} catch (MailException e){
			email.setStatusEmail(StatusEmail.ERROR);
		} finally {
			return repository.save(email);
		}
	}
}
