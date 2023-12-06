package com.rating.service.services.serviceImpl;

import com.rating.service.dtos.RatingDto;
import com.rating.service.entities.Rating;
import com.rating.service.exception.ResourceNotFoundException;
import com.rating.service.mapper.Mapper;
import com.rating.service.repositories.RatingRepository;
import com.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public RatingDto createRating(RatingDto ratingDto) {
        Rating rating = Mapper.mapDtoToEntity(ratingDto);
        Rating save = ratingRepository.save(rating);
        RatingDto ratingDto1 = Mapper.mapEntityToDto(save);
        return ratingDto1;
    }

    @Override
    public RatingDto getRating(long ratingId) {

        Rating rating = ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("Rating with this id not found !!"));
        RatingDto ratingDto = Mapper.mapEntityToDto(rating);
        return ratingDto;
    }

    @Override
    public List<RatingDto> getAllRating() {
        List<Rating> all = ratingRepository.findAll();
        List<RatingDto> collect = all.stream().map(e -> Mapper.mapEntityToDto(e)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<RatingDto> getRatingByUserId(int userId) {
        List<Rating> byUserId = ratingRepository.getByUserId(userId);
        List<RatingDto> collect = byUserId.stream().map(e -> Mapper.mapEntityToDto(e)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<RatingDto> getRatingByHotelId(int hotelId) {

        List<Rating> byHotelId = ratingRepository.getByHotelId(hotelId);
        List<RatingDto> collect = byHotelId.stream().map(e -> Mapper.mapEntityToDto(e)).collect(Collectors.toList());
        return collect;
    }
}
