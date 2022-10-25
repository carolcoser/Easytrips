package br.com.agencia;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AgenciaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenciaSpringApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("12345"));
	}

}
