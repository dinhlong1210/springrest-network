package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({
	FileStorageProperties.class
})
@SpringBootApplication
public class SpringJwt1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwt1Application.class, args);
	}

}
