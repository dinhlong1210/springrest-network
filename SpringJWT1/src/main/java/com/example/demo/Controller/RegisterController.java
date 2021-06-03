package com.example.demo.Controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.Model.User;
import com.example.demo.Model.VerificationToken;
import com.example.demo.Repository.TokenRepository;
import com.example.demo.Security.MyUserDetailService;
import com.example.demo.Security.JWT.JwtUtils;
import com.example.demo.Security.Payload.Request.SignupRequest;
import com.example.demo.Security.Payload.Response.MessageResponse;
import com.example.demo.Security.Payload.Response.TokenRespons;
import com.example.demo.Service.UserService;
import com.example.demo.Service.Event.OnRegistrationSuccessEvent;

@CrossOrigin
@RestController
public class RegisterController {
	
	@Autowired
	private MyUserDetailService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageSource message;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Autowired
	private TokenRepository tokenRepo;
	
	@Autowired
	private JwtUtils jwtUtil;
	
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public ResponseEntity<?> RegisterAccount(@RequestBody SignupRequest signup){
		if(userService.checkIfUserExist(signup.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already taken!"));
		}
		User userRegister=new User();
		userRegister=userService.registerAccount(signup);
		 try {
				eventPublisher.publishEvent(new OnRegistrationSuccessEvent(userRegister));
			}catch(Exception re) {
				re.printStackTrace();
//				throw new Exception("Error while sending confirmation email");
			}
		return ResponseEntity.ok(new MessageResponse("Check Email"));	
	}
	
	
	@RequestMapping(value="/confirmRegistration",method=RequestMethod.GET)
	public ResponseEntity<?> confirmRegistration(@RequestParam("token") String token) {
		VerificationToken verificationToken=tokenRepo.findByToken(token);
		if(verificationToken == null) {
			return ResponseEntity.badRequest().build();
		}
		User user = verificationToken.getUser();
		Calendar calendar = Calendar.getInstance();
		if((verificationToken.getExpiryDate().getTime()-calendar.getTime().getTime())<=0) {
			return ResponseEntity.badRequest().build();
		}
		user.setActived(true);
		userService.saveAccount(user);
		return ResponseEntity.ok(new MessageResponse("Token is access"));
	}
}
