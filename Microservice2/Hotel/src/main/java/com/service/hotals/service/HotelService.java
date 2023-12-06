package com.service.hotals.service;

import com.service.hotals.dtos.HotelDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    HotelDto createHotel(HotelDto hotelDto);

    HotelDto getHotel(long id);

    List<HotelDto> getAllHotel();

}
