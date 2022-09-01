package com.company.service;

import com.company.repository.UserRepository;
import com.company.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public Optional<User> findById(int id) {
        return userRepo.findById(id);
    }
    public List<User> findAll() {
        return userRepo.findAll();
    }
    public User save(User user){
        return userRepo.save(user);
    }
    public void deleteById(int id){
        userRepo.deleteById(id);
    }
    public void delete(User user){
        userRepo.delete(user);
    }
}
