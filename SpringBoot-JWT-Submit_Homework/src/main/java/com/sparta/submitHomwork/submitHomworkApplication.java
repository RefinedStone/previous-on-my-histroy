package com.sparta.submitHomwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //timestamp 설정 관련
@SpringBootApplication
public class submitHomworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(submitHomworkApplication.class, args);
	}

}
