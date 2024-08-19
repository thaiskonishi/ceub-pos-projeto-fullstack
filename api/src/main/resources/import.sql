-- -- H2 Script - Sem necessidade de criar o BD quando usado o Quakus Framework

-- -- -----------------------------------------------------
-- -- Schema creation
-- -- -----------------------------------------------------
-- CREATE SCHEMA IF NOT EXISTS dbFinancas;

-- -- -----------------------------------------------------
-- -- Table SETOR
-- -- -----------------------------------------------------
-- DROP TABLE IF EXISTS SETOR;

-- CREATE TABLE SETOR (
--     ID INT PRIMARY KEY AUTO_INCREMENT,
--     NOME_SETOR VARCHAR(45) NOT NULL,
--     DESCRICAO VARCHAR(400),
--     CONSTRAINT NOME_SETOR_UNIQUE UNIQUE (NOME_SETOR)
-- );

-- -- -----------------------------------------------------
-- -- Table TIPO_ATIVO
-- -- -----------------------------------------------------
-- DROP TABLE IF EXISTS TIPO_ATIVO;

-- CREATE TABLE TIPO_ATIVO (
--     ID INT PRIMARY KEY AUTO_INCREMENT,
--     NOME_TIPO_ATIVO VARCHAR(45) NOT NULL,
--     DESCRICAO VARCHAR(400),
--     CONSTRAINT NOME_TIPO_ATIVO_UNIQUE UNIQUE (NOME_TIPO_ATIVO)
-- );

-- -- -----------------------------------------------------
-- -- Table ATIVO
-- -- -----------------------------------------------------
-- DROP TABLE IF EXISTS ATIVO;

-- CREATE TABLE ATIVO (
--     ID INT PRIMARY KEY AUTO_INCREMENT,
--     NOME VARCHAR(45) NOT NULL,
--     TICKER VARCHAR(45) NOT NULL UNIQUE,
--     DATA_FUNDACAO DATE NOT NULL,
--     ID_SETOR INT NOT NULL,
--     ID_TIPO_ATIVO INT NOT NULL,
--     CONSTRAINT COD_SETOR_idx FOREIGN KEY (ID_SETOR) 
--         REFERENCES SETOR (ID),
--     CONSTRAINT COD_TIPO_ATIVO_idx FOREIGN KEY (ID_TIPO_ATIVO) 
--         REFERENCES TIPO_ATIVO (ID)
-- );

-- -- -----------------------------------------------------
-- -- Table COTACAO
-- -- -----------------------------------------------------
-- DROP TABLE IF EXISTS COTACAO;

-- CREATE TABLE COTACAO (
--     ID INT PRIMARY KEY AUTO_INCREMENT,
--     ID_ATIVO INT NOT NULL,
--     DATA TIMESTAMP NOT NULL,
--     COTACAO DOUBLE NOT NULL,
--     CONSTRAINT ID_ATIVO_FK FOREIGN KEY (ID_ATIVO) 
--         REFERENCES ATIVO (ID)
-- );

-- -- -----------------------------------------------------
-- -- Table HISTORICO_COTACAO
-- -- -----------------------------------------------------
-- DROP TABLE IF EXISTS HISTORICO_COTACAO;

-- CREATE TABLE HISTORICO_COTACAO (
--     ID INT PRIMARY KEY AUTO_INCREMENT,
--     ID_ATIVO INT NOT NULL,
--     DATA TIMESTAMP NOT NULL,
--     COTACAO DOUBLE NOT NULL
-- );

-- Inserts para a tabela SETOR

INSERT INTO SETOR (NOME_SETOR)
VALUES 
('Bancos'),
('Tecnologia'),
('Energia'),
('Saúde'),
('Consumo Discricionário'),
('Consumo Básico'),
('Materiais Básicos'),
('Telecomunicações'),
('Imobiliário'),
('Indústria');

INSERT INTO TIPO_ATIVO (NOME_TIPO_ATIVO)
VALUES 
('Ação'),
('Fundo de Investimento Imobiliário'),
('Fundo de Investimento nas Cadeias Produtivas Agroindustriais');