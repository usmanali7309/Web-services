package com.micro.user.dtos;

import com.micro.user.pojos.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int userId;

    private String name;

    private String email;

    private String phone;

    private String about;

    private List<Rating> ratings;

}
