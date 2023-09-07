package com.lcwd.rating.controller;

import com.lcwd.rating.entity.Rating;
import com.lcwd.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService rs;

    @PostMapping
    public ResponseEntity<Rating> saveRating(@RequestBody Rating r)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(rs.createRating(r));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> findAllRatings()
    {
        return ResponseEntity.status(HttpStatus.OK).body(rs.AllRatings());
    }

    @GetMapping("/Users/{userId}")
    public ResponseEntity<List<Rating>> findAllRatingsByUserId(@PathVariable String userId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(rs.getAllRatingsByUser(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> findAllRatingsByHotelId(@PathVariable String hotelId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(rs.getAllRatingsByHotel(hotelId));
    }


}
