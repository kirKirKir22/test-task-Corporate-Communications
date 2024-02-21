package com.CorpCommunications.contact.book;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class ContactBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactBookApplication.class, args);
	}

}
