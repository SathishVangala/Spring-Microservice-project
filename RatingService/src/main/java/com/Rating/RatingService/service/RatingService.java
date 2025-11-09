package com.Rating.RatingService.service;

import com.Rating.RatingService.entity.Ratings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    //Create
    Ratings create(Ratings ratings);
    //getAll
    List<Ratings> getAll();
    //getbyUserId
    List<Ratings> getByUserID(String userId);
    //getByHotelId
    List<Ratings> getByHotelId(String hotelId);

}
