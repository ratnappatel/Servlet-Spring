package com.hcl.MVCDemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.hcl")
public class MvcDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(MvcDemo1Application.class, args);
	}

}
