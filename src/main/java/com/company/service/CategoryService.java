package com.company.service;

import com.company.entity.Category;
import com.company.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepo;

    public Optional<Category> findById(int id) {
        return categoryRepo.findById(id);
    }
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
    public Category save(Category category){
        return categoryRepo.save(category);
    }
    public void deleteById(int id){
        categoryRepo.deleteById(id);
    }
    public void delete(Category category){
        categoryRepo.delete(category);
    }
}
