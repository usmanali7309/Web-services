package com.contact.ContactService.service;

import com.contact.ContactService.entity.Contact;
import com.contact.ContactService.payload.ContactDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {

    public ContactDto getContacts(int userId);

}
