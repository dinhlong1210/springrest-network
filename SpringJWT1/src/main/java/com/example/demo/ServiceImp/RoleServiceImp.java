package com.example.demo.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Roles;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Service.RoleService;

@Service
public class RoleServiceImp implements RoleService{
	
	
	@Autowired
	private RoleRepository roleRepo;
	@Override
	public Roles findByNameRoles(String roles) {
		// TODO Auto-generated method stub
		return roleRepo.findByNameRoles(roles);
	}

	@Override
	public List<Roles> findAllRoles() {
		// TODO Auto-generated method stub
		return roleRepo.findAll();
	}

}
