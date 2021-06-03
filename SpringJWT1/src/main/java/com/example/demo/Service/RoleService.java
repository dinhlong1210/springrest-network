package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Roles;

public interface RoleService {
	Roles findByNameRoles(String roles);
	List<Roles> findAllRoles();
}
