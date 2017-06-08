package com.coviam.blabla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

<<<<<<< HEAD
=======

>>>>>>> c611061565eec254c39eac7569d993f9fbd8fe80
@SpringBootApplication
public class BlablaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlablaApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
<<<<<<< HEAD
	
	
=======

>>>>>>> c611061565eec254c39eac7569d993f9fbd8fe80
}