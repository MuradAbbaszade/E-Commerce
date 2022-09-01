package com.company.repository;

import com.company.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
    public List<User> findByEmail(String email);
}
