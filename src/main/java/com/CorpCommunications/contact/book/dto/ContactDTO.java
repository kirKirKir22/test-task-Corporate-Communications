package com.CorpCommunications.contact.book.dto;


import com.CorpCommunications.contact.book.ContactType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {

    private Long id;
    private ContactType type;
    private String value;


}
