package com.baggiovictor.email.constrollers;

import com.baggiovictor.email.dtos.EmailDto;
import com.baggiovictor.email.models.EmailModel;
import com.baggiovictor.email.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	@Autowired
	EmailService service;

	@PostMapping("/sending-email")
	public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
		var emailModel = new EmailModel();
		BeanUtils.copyProperties(emailModel, emailModel);
		service.sendEmail(emailModel);
		return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
	}
}
