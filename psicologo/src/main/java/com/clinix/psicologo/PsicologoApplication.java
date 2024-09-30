package com.clinix.psicologo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PsicologoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PsicologoApplication.class, args);
	}

}
