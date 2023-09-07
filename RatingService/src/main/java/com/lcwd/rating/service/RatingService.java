package com.lcwd.rating.service;

import com.lcwd.rating.entity.Rating;

import java.util.List;

public interface RatingService {

    //create ratings
    Rating createRating(Rating rating);

    //all ratings
    List<Rating> AllRatings();

    //get all ratings by User
    List<Rating> getAllRatingsByUser(String userId);

    //get all ratings by hotel
    List<Rating> getAllRatingsByHotel(String hotelId);
}
