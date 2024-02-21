package com.CorpCommunications.contact.book.service;


import com.CorpCommunications.contact.book.dto.ContactDTO;
import com.CorpCommunications.contact.book.entity.ClientEntity;

import java.util.List;

public interface ContactService {

    ContactDTO addContact(Long clientId, ContactDTO contactDTO);
    List<ContactDTO> getContactsByClient(ClientEntity clientEntity);
    List<ContactDTO> getClientContactsByType(Long clientId, String contactType);
}
