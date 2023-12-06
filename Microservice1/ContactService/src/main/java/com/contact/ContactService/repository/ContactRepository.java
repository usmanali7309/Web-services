package com.contact.ContactService.repository;

import com.contact.ContactService.entity.Contact;
import com.contact.ContactService.payload.ContactDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
    public Contact getByUserId(int userId);
}
