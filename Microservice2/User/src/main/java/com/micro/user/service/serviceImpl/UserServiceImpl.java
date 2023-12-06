package com.micro.user.service.serviceImpl;

import com.micro.user.dtos.UserDto;
import com.micro.user.entities.User;
import com.micro.user.exceptions.ResourceNotFoundException;
import com.micro.user.mapper.Mapper;
import com.micro.user.repositories.UserRepository;
import com.micro.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = Mapper.mapDtoToEntity(userDto);
        User savedUser = userRepository.save(user);
        UserDto userDto1 = Mapper.mapEntityToDto(savedUser);
        return userDto1;
    }

    @Override
    public UserDto getUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id not found !!"));

        return Mapper.mapEntityToDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {

        List<User> allUser = userRepository.findAll();
        List<UserDto> userDto = allUser.stream().map(e -> Mapper.mapEntityToDto(e)).collect(Collectors.toList());
        return userDto;
    }
}
