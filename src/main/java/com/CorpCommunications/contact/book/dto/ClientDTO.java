package com.CorpCommunications.contact.book.dto;


import java.util.Objects;

public class ClientDTO {

    private Long clientId;
    private String name;

    public ClientDTO(Long clientId, String name) {
        this.clientId = clientId;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return Objects.equals(clientId, clientDTO.clientId) && Objects.equals(name, clientDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, name);
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                '}';
    }
}
