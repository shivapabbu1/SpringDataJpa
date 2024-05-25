package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SprinBoot_Cache {

	public static void main(String[] args) {
		SpringApplication.run(SprinBoot_Cache.class, args);
	}

}
