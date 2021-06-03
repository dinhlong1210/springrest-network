package com.example.demo.Service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;

import com.example.demo.Model.Roles;
import com.example.demo.Model.User;
import com.example.demo.Model.VerificationToken;
import com.example.demo.Security.Payload.Request.SignupAdminRequest;
import com.example.demo.Security.Payload.Request.SignupRequest;

public interface UserService {
	User registerAccount(SignupRequest userDto);
	public boolean checkIfUserExist(String email);
	User findByEmail(String email);
	void createVerificationToken(String token,User user);
	VerificationToken getVerificationToken(String token);
	User saveAccount(User user);
	User RegisterAccountAdmin(SignupAdminRequest signupadmin);
	Page<User> getUserByRoles(Set<Roles> vaiTro, int page);
	List<User> getUserByRoles(Set<Roles> vaiTro);
}
