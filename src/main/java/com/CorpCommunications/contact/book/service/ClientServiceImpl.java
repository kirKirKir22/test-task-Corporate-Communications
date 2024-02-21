package com.CorpCommunications.contact.book.service;


import com.CorpCommunications.contact.book.dto.ClientDTO;
import com.CorpCommunications.contact.book.entity.ClientEntity;
import com.CorpCommunications.contact.book.mapper.ClientMapper;
import com.CorpCommunications.contact.book.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<ClientEntity> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClientById(Long clientId) {
        ClientEntity client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + clientId));
        return clientMapper.toDTO(client);
    }

    @Override
    public ClientDTO addClient(ClientDTO clientDTO) {
        ClientEntity clientEntity = clientMapper.toEntity(clientDTO);
        ClientEntity savedClient = clientRepository.save(clientEntity);
        return clientMapper.toDTO(savedClient);
    }

}
