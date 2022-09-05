package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@ComponentScan
@Service
@SpringBootApplication
public class ECommerceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }

}