package com.company.dto;

import com.company.annotation.EmailExist;
import com.company.annotation.PasswordMatches;
import com.company.entity.Role;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@PasswordMatches
@EmailExist
public class UserDto {

    private int id;
    @NotEmpty(message = "Please fill the all fields")
    @Size(min = 2, max = 15, message = "Name size must be between 2 and 15")
    private String name;
    @Size(min = 3, max = 15, message = "Password size must be between 3 and 15")
    @NotEmpty(message = "Please fill the all fields")
    private String password;
    @NotEmpty(message = "Please fill the all fields")
    private String matchingPassword;
    @Size(min = 11, max = 45, message = "Email size must be between 11 and 45")
    @NotEmpty(message = "Please fill the all fields")
    private String email;
    private Double balance;
    private Role role;

    public UserDto(int id, String name, String password, String email, Double balance, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.balance = balance;
        this.role = role;
    }

    public UserDto() {
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
