package com.example.recipeCatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.example.recipeCatalog.repositories")
public class RecipeCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeCatalogApplication.class, args);
		System.out.println("Hello");
		}


	}
