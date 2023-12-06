package com.contact.ContactService.service;

import com.contact.ContactService.entity.Contact;
import com.contact.ContactService.payload.ContactDto;
import com.contact.ContactService.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService{

//    List<Contact> ls = Arrays.asList(new Contact(1,"amit@gmail.com","Amit",1311),
//            new Contact(2,"samir@gmail.com","Samir",1311),
//            new Contact(3,"anil@gmail.com","Anil",1312));

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public ContactDto getContacts(int userId) {
        Contact contact = contactRepository.getByUserId(userId);
        ContactDto contactDto = mapToDto(contact);
        return contactDto;
//        return ls.stream().filter(contact -> contact.getUserId().equals(userId)).findAny().orElse(null);
    }

    private ContactDto mapToDto(Contact contact) {
        ContactDto contactDto = new ContactDto();
        contactDto.setcId(contact.getcId());
        contactDto.setContactName(contact.getContactName());
        contactDto.setEmail(contact.getEmail());
        contactDto.setUserId(contact.getUserId());
        return contactDto;
    }
}
