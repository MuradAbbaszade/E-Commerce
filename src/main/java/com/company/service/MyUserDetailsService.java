package com.company.service;

import com.company.entity.User;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<User> users = userService.findByEmail(email);

        if (!users.isEmpty()) {
            UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(email);

            builder.disabled(false);
            builder.password(users.get(0).getPassword());
            User user = users.get(0);
            
            builder.authorities(user.getRole().getName());
            return builder.build();
        } else {
            throw new UsernameNotFoundException("Email or password incorrect.");
        }

    }
}
