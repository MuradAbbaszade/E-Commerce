package com.company;

import com.company.entity.Product;
import com.company.entity.Role;
import com.company.entity.User;
import com.company.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import com.company.repository.ProductRepository;
import com.company.service.UserService;
import java.util.Optional;

@ComponentScan
@Service
@SpringBootApplication
public class ECommerceApplication {

    @Autowired
    UserService userService;
    
    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) {
                User user = new User(1);
                user.setRole(new Role(1));
                User user1= userService.save(user);
                System.out.println(userService.findById(1));
            }
        };
        return clr;
    }

}