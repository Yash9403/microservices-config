package com.lcwd.rating.repository;

import com.lcwd.rating.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {

    //custom finder methods for finding the ratings on the basis of userId and HotelId


    //fromHotelId
    List<Rating> findByHotelId(String hotelId);

    //fromuserId
    List<Rating> findByUserId(String userId);
}
