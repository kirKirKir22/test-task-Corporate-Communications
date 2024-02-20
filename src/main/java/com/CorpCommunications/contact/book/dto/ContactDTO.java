package com.CorpCommunications.contact.book.dto;


import java.util.Objects;

public class ContactDTO {

    private Long contactId;
    private String phone;
    private String email;

    public ContactDTO(Long contactId, String phone, String email) {
        this.contactId = contactId;
        this.phone = phone;
        this.email = email;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDTO that = (ContactDTO) o;
        return Objects.equals(contactId, that.contactId) && Objects.equals(phone, that.phone) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, phone, email);
    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "contactId=" + contactId +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
