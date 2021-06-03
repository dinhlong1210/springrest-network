package com.example.demo.Service.Event;

import java.io.IOException;
import java.util.UUID;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import com.example.demo.ServiceImp.EmailService;

@Component
public class RegistrationEmailListener implements ApplicationListener<OnRegistrationSuccessEvent>{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService  emailService;
	
	@Autowired
	private MessageSource messages;

	@Autowired
    private JavaMailSender emailSender;
	
	@Override
	public void onApplicationEvent(OnRegistrationSuccessEvent event) {
		// TODO Auto-generated method stub
		try {
			this.confirmRegistration(event);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void confirmRegistration(OnRegistrationSuccessEvent event) throws MessagingException, IOException {
		User user = event.getUser();
		String token = UUID.randomUUID().toString();
		userService.createVerificationToken(token,user);
		
		String recipient = user.getEmail();
		String subject = "Registration Confirmation";
        String url 
          ="http://localhost:8080/confirmRegistration?token=" + token;
        

        MimeMessage message=emailSender.createMimeMessage();
        MimeMessageHelper  email = new MimeMessageHelper (message);   
        email.setTo(recipient);
        email.setSubject(subject);
        email.setText(url,true);
        email.setFrom("nguyendinhlongndl@gmail.com");
        
        emailService.sendEmail(message);
	}
}
