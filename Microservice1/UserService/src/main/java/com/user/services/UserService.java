package com.user.services;

import com.user.entity.User;
import com.user.payload.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public UserDto getUser(long id);
}
