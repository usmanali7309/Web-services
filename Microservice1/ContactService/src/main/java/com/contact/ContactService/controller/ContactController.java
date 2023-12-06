package com.contact.ContactService.controller;

import com.contact.ContactService.entity.Contact;
import com.contact.ContactService.payload.ContactDto;
import com.contact.ContactService.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<ContactDto> usersContact(@PathVariable("userId") int userId){
        ContactDto contacts = contactService.getContacts(userId);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

}
