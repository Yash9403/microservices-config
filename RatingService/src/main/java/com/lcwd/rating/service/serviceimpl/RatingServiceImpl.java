package com.lcwd.rating.service.serviceimpl;

import com.lcwd.rating.entity.Rating;
import com.lcwd.rating.repository.RatingRepository;
import com.lcwd.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository rr;

    @Override
    public Rating createRating(Rating rating) {
        String id = UUID.randomUUID().toString();
        rating.setRatingId(id);
        Rating rate = rr.save(rating);
        return rate;
    }

    @Override
    public List<Rating> AllRatings() {
        return rr.findAll();
    }

    @Override
    public List<Rating> getAllRatingsByUser(String userId) {
        return rr.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingsByHotel(String hotelId) {
        return rr.findByHotelId(hotelId);
    }
}
