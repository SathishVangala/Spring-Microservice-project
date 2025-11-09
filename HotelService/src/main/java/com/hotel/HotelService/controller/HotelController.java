package com.hotel.HotelService.controller;

import com.hotel.HotelService.entity.Hotel;
import com.hotel.HotelService.service.HotelService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.createHotel(hotel);
       return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
        List<Hotel> hotel = hotelService.getHotels();
        return ResponseEntity.status(HttpStatus.FOUND).body(hotel);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String id){
        Hotel hotel = hotelService.getHotelById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(hotel);
    }

}
