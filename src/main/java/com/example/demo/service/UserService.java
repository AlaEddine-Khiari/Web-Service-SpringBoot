package com.example.demo.service;

import com.example.demo.Model.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);
    public List<Object> isUserPresent(User user);
}
