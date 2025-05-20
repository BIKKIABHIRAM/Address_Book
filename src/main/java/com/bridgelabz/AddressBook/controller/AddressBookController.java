package com.bridgelabz.AddressBook.controller;

import com.bridgelabz.AddressBook.model.Contact;
import com.bridgelabz.AddressBook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/contacts")
public class AddressBookController {

    @Autowired
    private ContactRepository repository;

    @GetMapping
    public ResponseEntity<List<Contact>> getAllPersons() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getPersonById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contact> createPerson(@RequestBody Contact person) {
        return new ResponseEntity<>(repository.save(person), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updatePerson(@PathVariable Long id, @RequestBody Contact updatedPerson) {
        return repository.findById(id).map(existingPerson -> {
            existingPerson.setName(updatedPerson.getName());
            existingPerson.setAddress(updatedPerson.getAddress());
            return ResponseEntity.ok(repository.save(existingPerson));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        return repository.findById(id).map(person -> {
            repository.delete(person);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(ResponseEntity.notFound().build());
    }
}
