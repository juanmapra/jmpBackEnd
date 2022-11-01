package com.portfolio.jmp;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
//EnableAutoConfiguration
@EnableJpaRepositories
@CrossOrigin(origins = "http://localhost:8080")
public class JmpApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmpApplication.class, args);
	}

}
