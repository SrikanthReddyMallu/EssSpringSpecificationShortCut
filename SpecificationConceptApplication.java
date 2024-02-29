package com.example.SpecificationConcept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class SpecificationConceptApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpecificationConceptApplication.class, args);
	}

}
