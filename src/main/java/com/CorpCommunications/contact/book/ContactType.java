package com.CorpCommunications.contact.book;


public enum ContactType {

    PHONE("phone"),
    EMAIL("email");

    private final String value;

    ContactType(String value) {
        this.value = value;
    }

}

