package com.CorpCommunications.contact.book.service;

import com.CorpCommunications.contact.book.ContactType;
import com.CorpCommunications.contact.book.dto.ContactDTO;
import com.CorpCommunications.contact.book.entity.ClientEntity;
import com.CorpCommunications.contact.book.entity.ContactEntity;
import com.CorpCommunications.contact.book.mapper.ContactMapper;
import com.CorpCommunications.contact.book.repository.ClientRepository;
import com.CorpCommunications.contact.book.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;
    private final ClientRepository clientRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository, ContactMapper contactMapper, ClientRepository clientRepository) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ContactDTO> getContactsByClientId(Long clientId) {
        ClientEntity client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + clientId));

        List<ContactEntity> contacts = contactRepository.findByClient(client);
        return contacts.stream()
                .map(contactMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContactDTO> getContactsByClientIdAndType(Long clientId, ContactType type) {
        ClientEntity client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + clientId));

        List<ContactEntity> contacts = contactRepository.findByClientAndType(client, type);
        return contacts.stream()
                .map(contactMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDTO addContact(Long clientId, ContactDTO contactDTO) {
        ClientEntity client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + clientId));

        ContactEntity contactEntity = contactMapper.toEntity(contactDTO);
        contactEntity.setClient(client);

        ContactEntity savedContact = contactRepository.save(contactEntity);
        return contactMapper.toDTO(savedContact);
    }


}
