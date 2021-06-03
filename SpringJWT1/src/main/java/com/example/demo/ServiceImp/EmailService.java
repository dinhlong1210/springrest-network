package com.example.demo.ServiceImp;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Async
	public void sendEmail(MimeMessage email) {
		javaMailSender.send(email);
	}
}
