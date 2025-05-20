package com.bridgelabz.AddressBook.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping("")
    public String welcome() {
        return "Welcome to the Address Book REST API!";
    }

    @GetMapping("/contacts")
    public List<Map<String, String>> getContacts() {
        Map<String, String> contact1 = new HashMap<>();
        contact1.put("name", "Alice");
        contact1.put("email", "alice@example.com");
        contact1.put("phone", "1234567890");

        Map<String, String> contact2 = new HashMap<>();
        contact2.put("name", "Bob");
        contact2.put("email", "bob@example.com");
        contact2.put("phone", "9876543210");

        return Arrays.asList(contact1, contact2);
    }
}

