package com.CorpCommunications.contact.book.repository;

import com.CorpCommunications.contact.book.entity.ClientEntity;
import com.CorpCommunications.contact.book.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {

    List<ContactEntity> findByClient(ClientEntity client);
    List<ContactEntity> findByClientAndContactType(ClientEntity client, String contactType);

}