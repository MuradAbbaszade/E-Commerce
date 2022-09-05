package com.company.service;

import com.company.entity.Category;
import com.company.entity.Product;
import com.company.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.repository.ProductRepository;
import java.util.ArrayList;
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

    public List<Product> findByCategory(String categoryName) {
        List<Product> products = productRepo.findAll();
        List<Product> resultProducts = new ArrayList<>();
        if (categoryName.equals("all")) {
            return products;
        }
        for (Product product : products) {
            if (product.getCategory().getName().equals(categoryName)) {
                resultProducts.add(product);
            }
        }
        return resultProducts;
    }

    public List<Product> findByCategoryAndName(String productName, String categoryName) {
        List<Product> products = productRepo.findAll();
        List<Product> resultProducts = new ArrayList<>();
        if (categoryName.equals("all")) {
            resultProducts = productRepo.findByName(productName);
            return resultProducts;
        }
        for (Product product : products) {
            if (product.getCategory().getName().equals(categoryName) && product.getName().equals(productName)) {
                resultProducts.add(product);
            }
        }
        return resultProducts;
    }

}
