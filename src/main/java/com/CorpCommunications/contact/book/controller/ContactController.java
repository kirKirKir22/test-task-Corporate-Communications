package com.CorpCommunications.contact.book.controller;

import com.CorpCommunications.contact.book.ContactType;
import com.CorpCommunications.contact.book.dto.ContactDTO;
import com.CorpCommunications.contact.book.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<ContactDTO>> getContactsByClientId(@PathVariable Long clientId) {
        List<ContactDTO> contacts = contactService.getContactsByClientId(clientId);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/client/{clientId}/{type}")
    public ResponseEntity<List<ContactDTO>> getContactsByClientIdAndType(
            @PathVariable Long clientId, @PathVariable ContactType type) {
        List<ContactDTO> contacts = contactService.getContactsByClientIdAndType(clientId, type);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @PostMapping("/client/{clientId}")
    public ResponseEntity<ContactDTO> addContact(
            @PathVariable Long clientId, @RequestBody ContactDTO contactDTO) {
        ContactDTO addedContact = contactService.addContact(clientId, contactDTO);
        return new ResponseEntity<>(addedContact, HttpStatus.CREATED);
    }

}