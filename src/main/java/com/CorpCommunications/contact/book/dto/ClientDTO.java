package com.CorpCommunications.contact.book.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;
    private String name;
    private List<ContactDTO> contacts;

}
