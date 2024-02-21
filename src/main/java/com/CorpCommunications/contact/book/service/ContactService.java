package com.CorpCommunications.contact.book.service;


import com.CorpCommunications.contact.book.ContactType;
import com.CorpCommunications.contact.book.dto.ContactDTO;

import java.util.List;

public interface ContactService {

    List<ContactDTO> getContactsByClientId(Long clientId);
    List<ContactDTO> getContactsByClientIdAndType(Long clientId, ContactType type);
    ContactDTO addContact(Long clientId, ContactDTO contactDTO);

}
