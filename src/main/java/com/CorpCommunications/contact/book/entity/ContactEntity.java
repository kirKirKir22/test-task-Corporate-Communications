package com.CorpCommunications.contact.book.entity;

import com.CorpCommunications.contact.book.ContactType;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ContactType type;

    private String value;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;


}
