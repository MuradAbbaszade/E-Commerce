package com.company.service;

import com.company.entity.Product;
import com.company.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.repository.ProductRepository;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepo;

    public Optional<Product> findById(int id) {
        return productRepo.findById(id);
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public void deleteById(int id) {
        productRepo.deleteById(id);
    }

    public void delete(Product product) {
        productRepo.delete(product);
    }

    public List<Product> findByName(String name) {
        return productRepo.findByName(name);
    }

}
