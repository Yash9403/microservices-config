package com.lcwd.user.service.service.impl;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exception.ResourceNotFoundException;
import com.lcwd.user.service.external.services.HotelService;
import com.lcwd.user.service.repository.UserRepository;
import com.lcwd.user.service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository ur;

    @Autowired
    private HotelService hotelService;

    @Override
    public User saveuser(User u) {
        String userId = UUID.randomUUID().toString();
        u.setUserId(userId);
        User user = ur.save(u);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> all = ur.findAll();

        return all;
    }

    @Override
    public User getUser(String userId) {
        User user = ur.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User of giveID not found on Server " + userId));

        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGS-SERVICE/ratings/Users/" + user.getUserId(), Rating[].class);
        log.info("{} ", ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
    }
}
