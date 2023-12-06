package com.user.services;

import com.user.Repository.UserRepository;
import com.user.entity.User;
import com.user.payload.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService{


    @Autowired
     private UserRepository userRepository;

    @Override
    public UserDto getUser(long id) {

        User user = userRepository.findById(id).get();
        UserDto userDto = mapToDto(user);
//        return ls.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
        return userDto;
    }

    private UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setName(user.getName());
        userDto.setPhone(user.getPhone());
        return userDto;
    }


}