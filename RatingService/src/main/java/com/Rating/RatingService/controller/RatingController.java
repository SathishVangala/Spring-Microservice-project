package com.Rating.RatingService.controller;

import com.Rating.RatingService.entity.Ratings;
import com.Rating.RatingService.service.RatingService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @PostMapping
    public ResponseEntity<Ratings> createRating(@RequestBody Ratings ratings){
       Ratings ratings1 = ratingService.create(ratings);
       return ResponseEntity.status(HttpStatus.CREATED).body(ratings);

    }
    @GetMapping
    public ResponseEntity<List<Ratings>> getAll(){
        List<Ratings> ratings = ratingService.getAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(ratings);
    }
    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<Ratings>> getByUserId(@PathVariable  String userId){
        List<Ratings> userData = ratingService.getByUserID(userId);
        return ResponseEntity.status(HttpStatus.FOUND).body(userData);
    }

    @GetMapping("/{hotel}/{Id}")
    public ResponseEntity<List<Ratings>> getByHotelId(@PathVariable String Id){
        List<Ratings> hotelData = ratingService.getByHotelId(Id);
        return ResponseEntity.status(HttpStatus.FOUND).body(hotelData);
    }
}
