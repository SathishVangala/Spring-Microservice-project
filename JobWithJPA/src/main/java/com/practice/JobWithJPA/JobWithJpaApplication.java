package com.practice.JobWithJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobWithJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobWithJpaApplication.class, args);
		System.out.println("Server is Up");
	}

}
