package com.hotel.HotelService.service;

import com.hotel.HotelService.entity.Hotel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HotelService {

    Hotel createHotel(Hotel hotel);
    List<Hotel> getHotels();
    Hotel getHotelById(String id);

}
