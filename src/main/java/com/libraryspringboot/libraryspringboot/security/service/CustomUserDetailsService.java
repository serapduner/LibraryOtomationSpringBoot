package com.libraryspringboot.libraryspringboot.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private DummyUserService dummyUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         return dummyUserService.getUserByUsername(username);

        /*final User user = dummyUserService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username;
        }
        UserDetails user = User.withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("USER").build();
        return user;*/
    }
}
