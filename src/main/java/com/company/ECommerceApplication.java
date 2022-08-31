package com.company;

import com.company.daoInter.ProductDaoInter;
import com.company.entity.Product;
import com.company.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@ComponentScan
@Service
@SpringBootApplication
public class ECommerceApplication {

    @Autowired
    ProductDaoInter productDao;
    
    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) {
                List<Product> products= productDao.getAllProducts();
                System.out.println(products);
            }

        };
        return clr;
    }

}