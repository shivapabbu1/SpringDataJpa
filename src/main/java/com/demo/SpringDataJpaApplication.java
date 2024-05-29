package com.demo;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}
	@Bean
	public AuditorAware<String> auditorProvider() {
		return new AuditorAwareImpl();
	}

	class AuditorAwareImpl implements AuditorAware<String> {
		@Override
		public Optional<String> getCurrentAuditor() {
			// Return the currently authenticated user or a default user.
			// For simplicity, returning a static user here.
			return Optional.of("Employee");
		}
	}

}



