package com.CorpCommunications.contact.book.mapper;

import com.CorpCommunications.contact.book.dto.ClientDTO;
import com.CorpCommunications.contact.book.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toDto(ClientEntity clientEntity);
    ClientEntity toEntity(ClientDTO clientDTO);
}
