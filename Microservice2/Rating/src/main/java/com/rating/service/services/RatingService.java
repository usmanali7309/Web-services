package com.rating.service.services;

import com.rating.service.dtos.RatingDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    RatingDto createRating(RatingDto ratingDto);

    RatingDto getRating(long ratingId);

    List<RatingDto> getAllRating();

    List<RatingDto> getRatingByUserId(int userId);

    List<RatingDto> getRatingByHotelId(int hotelId);


}
