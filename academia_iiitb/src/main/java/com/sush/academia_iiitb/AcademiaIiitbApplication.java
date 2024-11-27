package com.sush.academia_iiitb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AcademiaIiitbApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademiaIiitbApplication.class, args);
	}

}
