package com.CorpCommunications.contact.book.dto;


import java.util.List;
import java.util.Objects;

public class ClientDTO {

    private Long clientId;
    private String name;
    private List<ContactDTO> contacts;

    public ClientDTO(Long clientId, String name, List<ContactDTO> contacts) {
        this.clientId = clientId;
        this.name = name;
        this.contacts = contacts;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ContactDTO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return Objects.equals(clientId, clientDTO.clientId) && Objects.equals(name, clientDTO.name) && Objects.equals(contacts, clientDTO.contacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, name, contacts);
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
