package com.CorpCommunications.contact.book.service;

import com.CorpCommunications.contact.book.dto.ContactDTO;
import com.CorpCommunications.contact.book.entity.ClientEntity;
import com.CorpCommunications.contact.book.entity.ContactEntity;
import com.CorpCommunications.contact.book.mapper.ContactMapper;
import com.CorpCommunications.contact.book.repository.ClientRepository;
import com.CorpCommunications.contact.book.repository.ContactRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;
    private ContactMapper contactMapper;
    private ClientRepository clientRepository;


    @Override
    public ContactDTO addContact(Long clientId, ContactDTO contactDTO) {
        ClientEntity client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));

        ContactEntity contactEntity = contactMapper.toEntity(contactDTO);
        contactEntity.setClient(client);

        ContactEntity savedContact = contactRepository.save(contactEntity);
        return contactMapper.toDto(savedContact);
    }

    @Override
    public List<ContactDTO> getContactsByClient(ClientEntity clientEntity) {
        List<ContactEntity> contacts = contactRepository.findByClient(clientEntity);
        return contacts.stream()
                .map(contactMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<ContactDTO> getClientContactsByType(Long clientId, String contactType) {
        ClientEntity client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));

        List<ContactEntity> contacts = contactRepository.findByClientAndContactType(client, contactType);
        return contacts.stream()
                .map(contactMapper::toDto)
                .collect(Collectors.toList());
    }
}