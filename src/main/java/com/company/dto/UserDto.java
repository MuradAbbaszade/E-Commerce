package com.company.dto;

import com.company.entity.Role;

public class UserDto {

    private int id;
    private String name;
    private String password;
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
