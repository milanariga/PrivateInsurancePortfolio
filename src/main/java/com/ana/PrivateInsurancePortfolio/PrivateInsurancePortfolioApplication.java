package com.ana.PrivateInsurancePortfolio;

import com.ana.PrivateInsurancePortfolio.model.SystemUser;
import com.ana.PrivateInsurancePortfolio.repositories.UserRepository;
import org.springframework.aop.TargetSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrivateInsurancePortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrivateInsurancePortfolioApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository){
		return args -> {
			SystemUser jake = new SystemUser("Jake", "Brown", "jake.brown", "pass123", "test@test.com", "+37122222222");
			userRepository.save(jake);
		};
	}
}
