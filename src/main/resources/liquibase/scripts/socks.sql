--liquibase formatted sql

-- changeset elenazmeeva:1
CREATE TABLE socks (
    id serial,
    color text,
    cottonPart INTEGER,
    quantity INTEGER
)
