package com.user.controller;

import com.user.entity.User;
import com.user.payload.Contact;
import com.user.payload.UserDto;
import com.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable("userId") long userId){

        UserDto user = userService.getUser(userId);
        Contact contacts = restTemplate.getForObject("http://CONTACTSERVICE/contact/user/" + userId, Contact.class);
        user.setContacts(contacts);

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    private void getForObject(String s, Class<Contact> contactClass) {
    }

}
