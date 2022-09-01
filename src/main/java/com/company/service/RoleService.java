package com.company.service;

import com.company.repository.RoleRepository;
import com.company.entity.Role;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepo;

    public Optional<Role> findById(int id) {
        return roleRepo.findById(id);
    }
    public List<Role> findAll() {
        return roleRepo.findAll();
    }
    public Role save(Role role){
        return roleRepo.save(role);
    }
    public void deleteById(int id){
        roleRepo.deleteById(id);
    }
    public void delete(Role role){
        roleRepo.delete(role);
    }
}
