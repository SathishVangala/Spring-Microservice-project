package com.security.SpringSecurity_pract.repo;

import com.security.SpringSecurity_pract.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserDetailsRepo extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
