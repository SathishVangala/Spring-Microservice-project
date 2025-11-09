package com.userTest.UserServiceTest.service;

import com.userTest.UserServiceTest.entity.Users;
import com.userTest.UserServiceTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users saveUsers(Users user){
        System.out.println("Inside add");
        return userRepository.save(user);
    }
    public List<Users> getUsers(){
        return userRepository.findAll();
    }
    public Optional<Users> getUserByID(Long id){
        return userRepository.findById(id);
    }

}
