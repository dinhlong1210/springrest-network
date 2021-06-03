package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long>{
	Roles findByNameRoles(String nameroles);
}
