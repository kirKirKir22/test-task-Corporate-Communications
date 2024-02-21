package com.CorpCommunications.contact.book.mapper;

import com.CorpCommunications.contact.book.dto.ContactDTO;
import com.CorpCommunications.contact.book.entity.ContactEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactDTO toDto(ContactEntity contactEntity);
    ContactEntity toEntity(ContactDTO contactDTO);
}