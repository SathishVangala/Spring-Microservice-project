package com.security.SpringSecurity_pract.service;

import com.security.SpringSecurity_pract.model.User;
import com.security.SpringSecurity_pract.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDetailsRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public User saveUser(User user){
        user.setPass(encoder.encode(user.getPass()));
        System.out.println(user.getPass());
        return repo.save(user);
    }
}