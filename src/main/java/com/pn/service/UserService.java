package com.pn.service;


import com.pn.entity.User;

public interface UserService {
    public User studentLogin(String username, String password);
}