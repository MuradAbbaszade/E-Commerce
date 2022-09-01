package com.company.service;

import com.company.dto.UserDto;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService implements IUserRegisterService {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @Override
    public User registerNewUserAccount(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setBalance(0);
        user.setRole(roleService.findById(1).get());
        return userService.save(user);
    }

}
