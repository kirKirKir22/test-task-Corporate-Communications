package com.CorpCommunications.contact.book.service;

import com.CorpCommunications.contact.book.dto.ClientDTO;
import com.CorpCommunications.contact.book.dto.ContactDTO;
import com.CorpCommunications.contact.book.ContactType;

import java.util.List;

public interface ClientService {

    ClientDTO createClient(ClientDTO clientDTO);

    List<ClientDTO> getAllClients();

    ClientDTO getClientById(Long clientId);

    List<ContactDTO> getClientContacts(Long clientId);

    List<ContactDTO> getClientContactsByType(ContactType type, Long clientId);
}
