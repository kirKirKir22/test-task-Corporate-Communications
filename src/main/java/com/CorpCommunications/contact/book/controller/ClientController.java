package com.CorpCommunications.contact.book.controller;

import com.CorpCommunications.contact.book.dto.ClientDTO;
import com.CorpCommunications.contact.book.dto.ContactDTO;
import com.CorpCommunications.contact.book.service.ClientService;
import com.CorpCommunications.contact.book.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing clients and their contacts.
 */
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientService clientService;
    private ContactService contactService;

    /**
     * Adds a new client.
     *
     * @param clientDTO data of the new client
     * @return the added client
     */
    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO clientDTO) {
        ClientDTO addedClient = clientService.addClient(clientDTO);
        return new ResponseEntity<>(addedClient, HttpStatus.CREATED);
    }

    /**
     * Adds a new contact for a client (phone or email).
     *
     * @param clientId   client's identifier
     * @param contactDTO data of the new contact
     * @return the added contact
     */
    @PostMapping("/{clientId}/contacts")
    public ResponseEntity<ContactDTO> addContact(@PathVariable Long clientId, @RequestBody ContactDTO contactDTO) {
        ContactDTO addedContact = contactService.addContact(clientId, contactDTO);
        return new ResponseEntity<>(addedContact, HttpStatus.CREATED);
    }

    /**
     * Retrieves a list of all clients.
     *
     * @return the list of all clients
     */
    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    /**
     * Retrieves information about a specified client by its identifier.
     *
     * @param clientId client's identifier
     * @return information about the client
     */
    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long clientId) {
        ClientDTO client = clientService.getClientById(clientId);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    /**
     * Retrieves a list of contacts for a specified client.
     *
     * @param clientId client's identifier
     * @return the list of client's contacts
     */
    @GetMapping("/{clientId}/contacts")
    public ResponseEntity<List<ContactDTO>> getClientContacts(@PathVariable Long clientId) {
        List<ContactDTO> contacts = clientService.getClientContacts(clientId);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    /**
     * Retrieves a list of contacts of a specified type for a specified client.
     *
     * @param clientId    client's identifier
     * @param contactType type of the contact
     * @return the list of contacts of the specified type for the client
     */
    @GetMapping("/{clientId}/contacts/{contactType}")
    public ResponseEntity<List<ContactDTO>> getClientContactsByType(
            @PathVariable Long clientId, @PathVariable String contactType) {
        List<ContactDTO> contacts = contactService.getClientContactsByType(clientId, contactType);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }
}