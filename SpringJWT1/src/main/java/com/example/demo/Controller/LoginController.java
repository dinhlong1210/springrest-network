package com.example.demo.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Security.UserPrincipal;
import com.example.demo.Security.JWT.JwtUtils;
import com.example.demo.Security.Payload.Request.LoginRequest;
import com.example.demo.Security.Payload.Response.LoginRespons;
import com.example.demo.Security.Payload.Response.MessageResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private JwtUtils jwtutils;
	
	@PostMapping(path = "/login")
	public ResponseEntity<?> authenticateLogin(@RequestBody LoginRequest loginrequest) {
		Authentication authentication=authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginrequest.getEmail(), loginrequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt=jwtutils.generateJwtToken(authentication);
		UserPrincipal userprinc=(UserPrincipal) authentication.getPrincipal();
		List<String> roles = userprinc.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok(new LoginRespons(jwt,userprinc.getIdUser(),userprinc.getFullName(),userprinc.getEmail(),roles));
		//new LoginRespons(jwt,userprinc.getEmail(),userprinc.getUsername(),roles
	}

}
