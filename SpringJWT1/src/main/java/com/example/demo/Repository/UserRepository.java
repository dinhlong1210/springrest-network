package com.example.demo.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.Model.Roles;
import com.example.demo.Model.User;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
	User findByUserid(Long id);
	Page<User> findByRolesIn(Set<Roles> roles,Pageable pageable);
	List<User> findByRolesIn(Set<Roles> roles);
	
}
	