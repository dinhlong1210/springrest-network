package com.example.demo.ServiceImp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Roles;
import com.example.demo.Model.User;
import com.example.demo.Model.VerificationToken;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.TokenRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Security.Payload.Request.SignupAdminRequest;
import com.example.demo.Security.Payload.Request.SignupRequest;
import com.example.demo.Service.UserService;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncode;
	
	@Autowired
	private TokenRepository tokenRepo;
	
	@Override
	public User registerAccount(SignupRequest userDto) {
		// TODO Auto-generated method stub
		User user =new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPassword(passwordEncode.encode(userDto.getPassword()));
		user.setEmail(userDto.getEmail());
		user.setAddress(userDto.getAddress());
		user.setSdt(userDto.getSdt());
		user.setActived(false);
		Set<Roles> setroles=new HashSet<>();
		setroles.add(roleRepo.findByNameRoles("ROLE_USER"));
		user.setRoles(setroles);
		return userRepo.save(user);
	}

	@Override
	public boolean checkIfUserExist(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email) !=null ?true:false;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

	@Override
	public void createVerificationToken(String token, User user) {
		// TODO Auto-generated method stub
		VerificationToken mytoken=new VerificationToken(token,user);
		tokenRepo.save(mytoken);
	}

	@Override
	public VerificationToken getVerificationToken(String token) {
		// TODO Auto-generated method stub
		return tokenRepo.findByToken(token);
	}

	@Override
	public User saveAccount(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}


	@Override
	public User RegisterAccountAdmin(SignupAdminRequest signupadmin) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setFirstName(signupadmin.getFirstName());
		user.setLastName(signupadmin.getLastName());
		user.setAddress(signupadmin.getAddress());
		user.setActived(true);
		user.setPassword(passwordEncode.encode(signupadmin.getPassword()));
		Set<Roles> setroles=new HashSet<>();
		setroles.add(roleRepo.findByNameRoles("ROLE_EMPLOYEE"));
		user.setRoles(setroles);
		user.setSdt(signupadmin.getSdt());
		user.setEmail(signupadmin.getEmail());
		return userRepo.save(user);
	}

	@Override
	public Page<User> getUserByRoles(Set<Roles> vaiTro, int page) {
		 //TODO Auto-generated method stub
		return userRepo.findByRolesIn(vaiTro, PageRequest.of(page-1, 16));
	}

	@Override
	public List<User> getUserByRoles(Set<Roles> vaiTro) {
		 //TODO Auto-generated method stub
		return userRepo.findByRolesIn(vaiTro);
	}	
}
