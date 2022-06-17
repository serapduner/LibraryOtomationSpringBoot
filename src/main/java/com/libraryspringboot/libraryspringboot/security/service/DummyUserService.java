package com.libraryspringboot.libraryspringboot.security.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class DummyUserService {
    private Map<String, User> users = new HashMap<>();

    @PostConstruct

    public void initialize() {
        users.put("serap", new User("serap", "123",new ArrayList<>()));
        users.put("hilal", new User("hilal", "124",new ArrayList<>()));
        users.put("dilek", new User("dilek", "123",new ArrayList<>()));
    }

    public User getUserByUsername(String username) {
        return users.get(username);
    }

    public User findByUsername(String username) {
        return users.get(username);
    }

    public User getUserByPassword(String password) {
        return users.get(password);
    }
}
