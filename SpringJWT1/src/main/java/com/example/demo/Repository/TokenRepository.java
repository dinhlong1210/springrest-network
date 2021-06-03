package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.VerificationToken;

public interface TokenRepository extends JpaRepository<VerificationToken, Long>{
	VerificationToken findByToken(String token);
	VerificationToken save(VerificationToken token);
}
