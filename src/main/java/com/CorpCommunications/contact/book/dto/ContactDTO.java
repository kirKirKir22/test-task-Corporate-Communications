package com.CorpCommunications.contact.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {

    private Long contactId;
    private String contactType;
    private String contactValue;


}
