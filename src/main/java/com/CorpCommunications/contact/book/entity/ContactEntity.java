package com.CorpCommunications.contact.book.entity;

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
    private Long contactId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @Column(nullable = false)
    private String contactType;

    @Column(nullable = false)
    private String contactValue;


}
