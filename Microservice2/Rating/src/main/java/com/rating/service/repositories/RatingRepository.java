package com.rating.service.repositories;

import com.rating.service.dtos.RatingDto;
import com.rating.service.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {

    List<Rating> getByUserId(int userId);

    List<Rating> getByHotelId(int hotelId);

}
