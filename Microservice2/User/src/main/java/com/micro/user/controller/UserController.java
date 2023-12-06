package com.micro.user.controller;

import com.micro.user.dtos.UserDto;
import com.micro.user.externalService.HotelService;
import com.micro.user.pojos.Hotel;
import com.micro.user.pojos.Rating;
import com.micro.user.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<UserDto> userCreated(@RequestBody UserDto userDto){

        UserDto user = userService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") int userId){

        UserDto user = userService.getUser(userId);

//        http://localhost:9003/ratings/user/
        Rating[] forObject = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/" + userId, Rating[].class);
        List<Rating> ratings = Arrays.stream(forObject).collect(Collectors.toList());
        user.setRatings(ratings);

        ratings.stream().map(rating -> {

//            api call to hotel service
//            Hotel hotelObject = restTemplate.getForObject("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);

//            using Feign client
            Hotel hotelObject = hotelService.getHotel(rating.getHotelId());

//            set the hotel to rating
           rating.setHotel(hotelObject);

//            return rating
            return rating;

        }).collect(Collectors.toList());

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

//    ratingHotelFallBackMethod
    public ResponseEntity<UserDto> ratingHotelFallback(String userId, Exception ex){
        UserDto userDto = new UserDto();
        userDto.setEmail("dummy@gmail.com");
        userDto.setName("Dummy");
        userDto.setAbout("This user is created dummy because some service is down");
         return  new ResponseEntity<>(userDto,HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getUser(){

        List<UserDto> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);

    }



}
