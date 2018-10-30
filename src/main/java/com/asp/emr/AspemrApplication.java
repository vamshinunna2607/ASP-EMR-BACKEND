package com.asp.emr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.asp.emr","controller"})

public class AspemrApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspemrApplication.class, args);
	}
}
