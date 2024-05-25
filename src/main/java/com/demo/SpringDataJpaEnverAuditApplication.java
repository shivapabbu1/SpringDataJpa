package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass =EnversRevisionRepositoryFactoryBean.class)
public class SpringDataJpaEnverAuditApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaEnverAuditApplication.class, args);
	}

}
