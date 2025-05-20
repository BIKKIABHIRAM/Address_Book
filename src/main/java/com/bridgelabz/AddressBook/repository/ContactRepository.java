package com.bridgelabz.AddressBook.repository;

import com.bridgelabz.AddressBook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}

