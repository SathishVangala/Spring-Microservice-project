package com.userService.UserService.controllers;

import com.userService.UserService.entities.User;
import com.userService.UserService.imple.UserServiceImpl;
import com.userService.UserService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
       User user1= userService.saveUser(user);
      return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users =  userService.getAllUser();
        return ResponseEntity.status(HttpStatus.FOUND).body(users);
    }
  int retryCount = 1;
    @GetMapping("/{userId}")
    //@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    @Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        logger.info("Retry Count: {}",retryCount);
        retryCount++;
        User userById=userService.getUser(userId);

        System.out.println(retryCount);

        return ResponseEntity.status(HttpStatus.FOUND).body(userById);

    }


    public ResponseEntity<User> ratingHotelFallback (String userId, Exception ex){
        logger.info("Fallback is executed because service is down: {}",ex.getMessage());
       User user= User.builder().userId("Dummy").email("dummy@gmail.com").name("dummy").build();

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
