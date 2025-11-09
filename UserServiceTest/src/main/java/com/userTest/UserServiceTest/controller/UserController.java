package com.userTest.UserServiceTest.controller;

import com.userTest.UserServiceTest.entity.Users;
import com.userTest.UserServiceTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
     UserService userService;

    @PostMapping
    public Users createUser(@RequestBody  Users user){
        return userService.saveUsers(user);
    }
    @GetMapping
    public List<Users> getAllUsers(){
        return userService.getUsers();
    }
    @GetMapping("/{userId}")
    public Optional<Users> getById(@PathVariable Long userId){
        return userService.getUserByID(userId);
    }
}
