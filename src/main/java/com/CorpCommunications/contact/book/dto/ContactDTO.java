package com.CorpCommunications.contact.book.dto;


import java.util.Objects;

public class ContactDTO {

    private Long contactId;
    private String contactType;
    private String value;

    public ContactDTO(Long contactId, String contactType, String value) {
        this.contactId = contactId;
        this.contactType = contactType;
        this.value = value;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDTO that = (ContactDTO) o;
        return Objects.equals(contactId, that.contactId) && Objects.equals(contactType, that.contactType) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, contactType, value);
    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "contactId=" + contactId +
                ", contactType='" + contactType + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
