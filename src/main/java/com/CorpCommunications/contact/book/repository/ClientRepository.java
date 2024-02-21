package com.CorpCommunications.contact.book.repository;

import com.CorpCommunications.contact.book.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
