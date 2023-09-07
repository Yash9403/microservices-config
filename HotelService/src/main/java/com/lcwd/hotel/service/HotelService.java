package com.lcwd.hotel.service;

import com.lcwd.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel saveHotel(Hotel h);

    List<Hotel> getAllHotels();

    Hotel getHotel(String hotelId);
}
