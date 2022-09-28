package com.example.table_employee.springbootpostgresqltable_employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;


@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class SpringbootPostgresqlTableEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootPostgresqlTableEmployeeApplication.class, args);
		System.out.println("Hello World");

	}

}
