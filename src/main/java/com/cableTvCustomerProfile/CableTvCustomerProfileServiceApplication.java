package com.cableTvCustomerProfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
@ComponentScan("com.cableTvCustomerProfile.*")
public class CableTvCustomerProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CableTvCustomerProfileServiceApplication.class, args);
	}

}
