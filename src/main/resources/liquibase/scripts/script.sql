-- liquibase formatted sql

CREATE TABLE Client (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Contact (
    id SERIAL PRIMARY KEY,
    type VARCHAR(10) NOT NULL,
    value VARCHAR(255) NOT NULL,
    client_id BIGINT REFERENCES Client(id)
);

ALTER TABLE Contact
ADD CONSTRAINT fk_client
FOREIGN KEY (client_id)
REFERENCES Client(id)
ON DELETE CASCADE;