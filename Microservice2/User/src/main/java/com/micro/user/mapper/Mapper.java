package com.micro.user.mapper;

import com.micro.user.dtos.UserDto;
import com.micro.user.entities.User;

public class Mapper {

    public static User mapDtoToEntity(UserDto userDto){
        User user = new User();

//        user.setUserId(userDto.getUserId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setAbout(userDto.getAbout());

        return user;

    }

    public static UserDto mapEntityToDto(User user){

        UserDto userDto = new UserDto();

        userDto.setUserId(user.getUserId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setAbout(user.getAbout());

        return userDto;
    }


}
