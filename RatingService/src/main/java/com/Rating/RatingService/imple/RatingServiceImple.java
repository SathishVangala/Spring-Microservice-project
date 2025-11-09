package com.Rating.RatingService.imple;

import com.Rating.RatingService.entity.Ratings;
import com.Rating.RatingService.repository.RatingRepository;
import com.Rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImple implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Ratings create(Ratings ratings) {
        return ratingRepository.save(ratings);
    }

    @Override
    public List<Ratings> getAll() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Ratings> getByUserID(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Ratings> getByHotelId(String hotelId) {
        System.out.println("insode");
        return ratingRepository.findByHotelId(hotelId);
    }
}
