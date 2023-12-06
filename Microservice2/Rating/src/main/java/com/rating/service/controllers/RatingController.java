package com.rating.service.controllers;

import com.rating.service.dtos.RatingDto;
import com.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<RatingDto> create(@RequestBody RatingDto ratingDto){
        RatingDto rating = ratingService.createRating(ratingDto);
        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RatingDto>> getAll(){

        List<RatingDto> allRating = ratingService.getAllRating();
        return new ResponseEntity<>(allRating,HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RatingDto>> getRatingByUserId(@PathVariable("userId") int userId){

        List<RatingDto> allRating = ratingService.getRatingByUserId(userId);
        return new ResponseEntity<>(allRating,HttpStatus.OK);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<RatingDto>> getRatingHotelId(@PathVariable("hotelId") int hotelId){

        List<RatingDto> allRating = ratingService.getRatingByHotelId(hotelId);
        return new ResponseEntity<>(allRating,HttpStatus.OK);
    }

}
