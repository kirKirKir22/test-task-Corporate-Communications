package com.CorpCommunications.contact.book.service;

import com.CorpCommunications.contact.book.dto.ClientDTO;
import com.CorpCommunications.contact.book.dto.ContactDTO;

import java.util.List;

public interface ClientService {

    List<ClientDTO> getAllClients();
    ClientDTO getClientById(Long clientId);
    ClientDTO addClient(ClientDTO clientDTO);
    List<ContactDTO> getClientContacts(Long clientId);

}
