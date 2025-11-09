package com.userService.UserService.imple;

import com.userService.UserService.entities.Hotel;
import com.userService.UserService.entities.Rating;
import com.userService.UserService.entities.User;
import com.userService.UserService.exception.ResourceNotFoundException;
import com.userService.UserService.external.service.HotelService;
import com.userService.UserService.repositories.UserRepository;
import com.userService.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

 private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
       // System.out.println(user.getName());
        //System.out.println(user.getUserId()+" "+user.getDateOfBirth());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given Id not found..!!"));
       Rating[] ratingsData= restTemplate.getForObject("http://RATINGSERVICE/rating/userId/"+user.getUserId(), Rating[].class);
       logger.info("{}",ratingsData);

    //   user.setRatings(List.of(ratingsData));
        List<Rating> ratings = Arrays.stream(ratingsData).toList();
       List<Rating> ratingList = ratings.stream()
               .map(rating -> {
                   //api call to hotel service to get the hotel
                   ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
                   Hotel hotel = forEntity.getBody();
                  // Hotel hotel = hotelService.getHotel(rating.getHotelId());
                   System.out.println(hotel.toString());
                 //  logger.info("ResponseCode {}",forEntity.getStatusCode());
                   rating.setHotel(hotel);
                   return rating;
               }).toList();
            user.setRatings(ratingList);


        return user;
    }
}
