package com.service.hotals.controller;

import com.service.hotals.dtos.HotelDto;
import com.service.hotals.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto){

        HotelDto hotel = hotelService.createHotel(hotelDto);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> getHotel(@PathVariable("id") long id){

        HotelDto hotel = hotelService.getHotel(id);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<HotelDto>> getAllHotel(){

        List<HotelDto> allHotel = hotelService.getAllHotel();
        return new ResponseEntity<>(allHotel, HttpStatus.OK);
    }
}
