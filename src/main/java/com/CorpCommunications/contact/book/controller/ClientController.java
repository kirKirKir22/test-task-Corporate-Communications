package com.CorpCommunications.contact.book.controller;

import com.CorpCommunications.contact.book.dto.ClientDTO;
import com.CorpCommunications.contact.book.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long clientId) {
        ClientDTO client = clientService.getClientById(clientId);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO clientDTO) {
        ClientDTO addedClient = clientService.addClient(clientDTO);
        return new ResponseEntity<>(addedClient, HttpStatus.CREATED);
    }

}