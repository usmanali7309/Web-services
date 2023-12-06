package com.service.hotals.service.serviceImpl;

import com.service.hotals.dtos.HotelDto;
import com.service.hotals.entities.Hotel;
import com.service.hotals.exceptions.ResourceNotFoundException;
import com.service.hotals.mapper.Mapper;
import com.service.hotals.ripositories.HotelRepository;
import com.service.hotals.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public HotelDto createHotel(HotelDto hotelDto) {
        Hotel hotel = Mapper.mapDtoToEntity(hotelDto);
        Hotel save = hotelRepository.save(hotel);
        HotelDto hotelDto1 = Mapper.mapEntityToDto(save);
        return hotelDto1;
    }

    @Override
    public HotelDto getHotel(long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found !!"));
        HotelDto hotelDto = Mapper.mapEntityToDto(hotel);
        return  hotelDto;
    }

    @Override
    public List<HotelDto> getAllHotel() {

        List<Hotel> all = hotelRepository.findAll();
        List<HotelDto> allHotelDto = all.stream().map(e -> Mapper.mapEntityToDto(e)).collect(Collectors.toList());

        return allHotelDto;
    }
}
