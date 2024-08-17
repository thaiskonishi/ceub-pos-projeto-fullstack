-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

-- Script adaptado para H2

CREATE SCHEMA dbFinancas;
-- CREATE DATABASE dbFinancas;
-- USE dbFinancas;

SET SCHEMA dbFinancas;

CREATE SEQUENCE Seq_ID
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE SETOR (
    ID INT PRIMARY KEY,
    NOME_SETOR VARCHAR(45) NOT NULL,
    DESCRICAO VARCHAR(400)
);

-- CREATE TABLE TIPO_ATIVO (
--     ID INT PRIMARY KEY,
--     NOME_TIPO_ATIVO VARCHAR(45) NOT NULL,
--     DESCRICAO VARCHAR(400)
-- );

-- CREATE TABLE ATIVO (
--     ID INT PRIMARY KEY,
--     NOME VARCHAR(45) NOT NULL,
--     TICKER VARCHAR(45) NOT NULL,
--     DATA_FUNDACAO DATE NOT NULL,
--     ID_SETOR INT NOT NULL,
--     ID_TIPO_ATIVO INT NOT NULL,
--     FOREIGN KEY (ID_SETOR) REFERENCES SETOR(ID),
--     FOREIGN KEY (ID_TIPO_ATIVO) REFERENCES TIPO_ATIVO(ID)
-- );

-- CREATE TABLE COTACAO (
--     ID INT PRIMARY KEY,
--     ID_ATIVO INT NOT NULL,
--     DATA TIMESTAMP NOT NULL,
--     COTACAO FLOAT NOT NULL,
--     FOREIGN KEY (ID_ATIVO) REFERENCES ATIVO(ID)
-- );

-- CREATE TABLE HISTORICO_COTACAO (
--     ID INT PRIMARY KEY,
--     ID_ATIVO INT NOT NULL,
--     DATA TIMESTAMP NOT NULL,
--     COTACAO FLOAT NOT NULL
-- );


-- DROP TABLE IF EXISTS SETOR;
-- DROP TABLE IF EXISTS TIPO_ATIVO;
-- DROP TABLE IF EXISTS COTACAO;
-- DROP TABLE IF EXISTS HISTORICO_COTACAO;
-- DROP TABLE IF EXISTS ATIVO;

-- DROP SEQUENCE Seq_ID;
-- DROP DATABASE dbFinancas;
-- DROP SCHEMA dbFinancas;