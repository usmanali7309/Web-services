package com.service.hotals.mapper;


import com.service.hotals.dtos.HotelDto;
import com.service.hotals.entities.Hotel;

public class Mapper {

    public static Hotel mapDtoToEntity(HotelDto hotelDto){
        Hotel hotel = new Hotel();

//
        hotel.setName(hotelDto.getName());
        hotel.setLocation(hotelDto.getLocation());
        hotel.setAbout(hotelDto.getAbout());

        return hotel;

    }

    public static HotelDto mapEntityToDto(Hotel hotel){

        HotelDto hotelDto = new HotelDto();

        hotelDto.setId(hotel.getId());
        hotelDto.setName(hotel.getName());
        hotelDto.setLocation(hotel.getLocation());
        hotelDto.setAbout(hotel.getAbout());

        return hotelDto;
    }


}
