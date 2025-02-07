package com.eric.drink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DrinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrinkApplication.class, args);
	}


}
