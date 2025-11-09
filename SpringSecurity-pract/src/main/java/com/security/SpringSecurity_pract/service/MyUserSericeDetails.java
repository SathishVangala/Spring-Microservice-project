package com.security.SpringSecurity_pract.service;

import com.security.SpringSecurity_pract.model.User;
import com.security.SpringSecurity_pract.model.UserPrincipal;
import com.security.SpringSecurity_pract.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserSericeDetails implements UserDetailsService {
    @Autowired
    private UserDetailsRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUserName(username);
        if(user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User Not Found");
        }
        return new UserPrincipal(user);

    }
}
