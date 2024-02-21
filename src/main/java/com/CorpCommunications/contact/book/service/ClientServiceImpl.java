package com.CorpCommunications.contact.book.service;

import com.CorpCommunications.contact.book.dto.ClientDTO;
import com.CorpCommunications.contact.book.dto.ContactDTO;
import com.CorpCommunications.contact.book.entity.ClientEntity;
import com.CorpCommunications.contact.book.mapper.ClientMapper;
import com.CorpCommunications.contact.book.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private ContactService contactService;
    private ClientMapper clientMapper;

    @Override
    public List<ClientDTO> getAllClients() {
        List<ClientEntity> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClientById(Long clientId) {
        ClientEntity client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));
        return clientMapper.toDto(client);
    }

    @Override
    public ClientDTO addClient(ClientDTO clientDTO) {
        ClientEntity clientEntity = clientMapper.toEntity(clientDTO);
        ClientEntity savedClient = clientRepository.save(clientEntity);
        return clientMapper.toDto(savedClient);
    }

    @Override
    public List<ContactDTO> getClientContacts(Long clientId) {
        ClientEntity client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));
        return contactService.getContactsByClient(client);
    }

}