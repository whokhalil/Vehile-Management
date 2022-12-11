package com.mukul.vehicle.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.SpringServletContainerInitializer;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Application {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new SpringSecurityAuditor();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
