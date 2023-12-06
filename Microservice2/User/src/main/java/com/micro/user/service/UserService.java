package com.micro.user.service;

import com.micro.user.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUser(int userId);

    List<UserDto> getAllUser();

}
