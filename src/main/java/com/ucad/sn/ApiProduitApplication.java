package com.ucad.sn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
public class ApiProduitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProduitApplication.class, args);
	}

}
