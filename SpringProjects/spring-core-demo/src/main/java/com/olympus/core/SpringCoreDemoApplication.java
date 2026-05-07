package com.olympus.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCoreDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringCoreDemoApplication.class, args);

        Employee emp = new Employee();
        emp.display();
    }
}