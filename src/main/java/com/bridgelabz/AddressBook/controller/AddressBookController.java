package com.bridgelabz.AddressBook.controller;

import com.bridgelabz.AddressBook.model.Contact;
import com.bridgelabz.AddressBook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class AddressBookController {

    @Autowired
    private ContactService contactService;

    // GET all
    @GetMapping
    public ResponseEntity<List<Contact>> getAllPersons() {
        List<Contact> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getPersonById(@PathVariable Long id) {
        return contactService.getContactById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST
    @PostMapping
    public ResponseEntity<Contact> createPerson(@RequestBody Contact person) {
        Contact savedContact = contactService.saveContact(person);
        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }

    // PUT by ID
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updatePerson(@PathVariable Long id, @RequestBody Contact updatedPerson) {
        Contact updatedContact = contactService.updateContact(id, updatedPerson);
        if (updatedContact != null) {
            return ResponseEntity.ok(updatedContact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
