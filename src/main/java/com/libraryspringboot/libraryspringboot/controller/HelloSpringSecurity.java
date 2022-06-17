package com.libraryspringboot.libraryspringboot.controller;

import com.libraryspringboot.libraryspringboot.security.service.DummyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloSpringSecurity {

    @Autowired
    DummyUserService dummyUserService;

    @GetMapping("/login")
    public String viewHomePage(Model model) {

        return "login";
}

    @PostMapping("/saveLogin")
    public String saveBook(@ModelAttribute("user") User user) {
        // save book to database
        dummyUserService.getUserByUsername(user.getUsername());
        dummyUserService.getUserByPassword(user.getPassword());
        return "login";
    }
}
