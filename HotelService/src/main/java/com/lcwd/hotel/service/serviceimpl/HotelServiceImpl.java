package com.lcwd.hotel.service.serviceimpl;

import com.lcwd.hotel.entity.Hotel;
import com.lcwd.hotel.exceptions.HotelNotFoundException;
import com.lcwd.hotel.repository.HotelRepository;
import com.lcwd.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hr;

    @Override
    public Hotel saveHotel(Hotel h) {
        String id = UUID.randomUUID().toString();
        h.setHotelId(id);
        Hotel hotel = hr.save(h);
        return hotel;
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> all = hr.findAll();
        return all;
    }

    @Override
    public Hotel getHotel(String hotelId) {
        Hotel hotel = hr.findById(hotelId).orElseThrow(() -> new HotelNotFoundException("Hotel not found with this id: " + hotelId));
        return hotel;
    }
}
