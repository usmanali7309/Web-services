package com.rating.service.mapper;

import com.rating.service.dtos.RatingDto;
import com.rating.service.entities.Rating;

public class Mapper {



    public static Rating mapDtoToEntity(RatingDto ratingDto){
        Rating rating = new Rating();

        rating.setUserId(ratingDto.getUserId());
        rating.setHotelId(ratingDto.getHotelId());
        rating.setRating(ratingDto.getRating());
        rating.setFeedback(ratingDto.getFeedback());

        return rating;
    }

    public static RatingDto mapEntityToDto(Rating rating){

        RatingDto ratingDto = new RatingDto();

        ratingDto.setRatingId(rating.getRatingId());
        ratingDto.setUserId(rating.getUserId());
        ratingDto.setHotelId(rating.getHotelId());
        ratingDto.setRating(rating.getRating());
        ratingDto.setFeedback(rating.getFeedback());

        return ratingDto;
    }
}
