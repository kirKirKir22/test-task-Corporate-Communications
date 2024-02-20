package com.CorpCommunications.contact.book.dto;

import java.util.List;
import java.util.Objects;

public class ClientWithContactsDto {

    private long clientId;
    private String firstName;
    private String lastName;
    private List<ContactDTO> contacts;

    public ClientWithContactsDto(long clientId, String firstName, String lastName, List<ContactDTO> contacts) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contacts = contacts;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        ClientWithContactsDto that = (ClientWithContactsDto) o;
        return clientId == that.clientId && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(contacts, that.contacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, firstName, lastName, contacts);
    }

    @Override
    public String toString() {
        return "ClientWithContactsDto{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}

