package com.lcwd.user.service.external.services;

import com.lcwd.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@FeignClient(name="RATINGS-SERVICE")
public interface RatingService {


    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(Rating rating);

    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    public void DeleteRating(@PathVariable("ratingId") String ratingId);
}
