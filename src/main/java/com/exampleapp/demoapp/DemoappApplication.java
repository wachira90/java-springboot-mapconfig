package com.exampleapp.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoappApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoappApplication.class, args);
		
		String java_home = System.getenv("JAVA_HOME");
        System.out.println(java_home);

		System.out.println("API SUCCESS");
	}

}
