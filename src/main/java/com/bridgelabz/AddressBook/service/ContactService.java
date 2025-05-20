package com.bridgelabz.AddressBook.service;

import com.bridgelabz.AddressBook.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> getAllContacts();
    Optional<Contact> getContactById(Long id);
    Contact saveContact(Contact contact);
    Contact updateContact(Long id, Contact contact);
    void deleteContact(Long id);
}
