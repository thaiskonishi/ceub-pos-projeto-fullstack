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

-- Inserts para a tabela TIPO_ATIVO

INSERT INTO TIPO_ATIVO (NOME_TIPO_ATIVO)
VALUES 
('Ação'),
('Fundo de Investimento Imobiliário'),
('Fundo de Investimento nas Cadeias Produtivas Agroindustriais');

-- Inserts para a tabela ATIVO

-- Inserts para Ações (ID_TIPO_ATIVO = 1)
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('PETROBRAS', 'PETR4', '1953-10-03', 3, 1);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('VALE', 'VALE3', '1942-06-01', 7, 1);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('AMBEV', 'ABEV3', '1999-07-01', 6, 1);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('ITAU UNIBANCO', 'ITUB4', '1924-01-01', 1, 1);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('BRADESCO', 'BBDC4', '1943-03-10', 1, 1);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('MAGAZINE LUIZA', 'MGLU3', '1957-11-16', 5, 1);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('B2W DIGITAL', 'BTOW3', '2006-12-01', 5, 1);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('LOJAS RENNER', 'LREN3', '1912-07-01', 5, 1);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('SANTANDER BRASIL', 'SANB11', '1982-08-09', 1, 1);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('BTG PACTUAL', 'BPAC11', '1983-09-11', 1, 1);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('COSAN', 'CSAN3', '1936-06-12', 6, 1);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('RAÍZEN', 'RAIZ4', '2011-06-01', 6, 1);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('WEG', 'WEGE3', '1961-09-16', 10, 1);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('GERDAU', 'GGBR4', '1901-01-16', 7, 1);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('JBS', 'JBSS3', '1953-12-31', 6, 1);

-- Inserts para FIIs e Fiagros (ID_TIPO_ATIVO = 2 e 3)
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('HGLG11', 'HGLG11', '2010-04-15', 9, 2);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('KNRI11', 'KNRI11', '2004-06-10', 9, 2);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('MXRF11', 'MXRF11', '2011-01-15', 9, 2);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('VISC11', 'VISC11', '2014-10-01', 5, 2);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('FIIB11', 'FIIB11', '2011-11-01', 9, 2);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('XPLG11', 'XPLG11', '2018-02-28', 9, 2);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('HGRE11', 'HGRE11', '2010-01-10', 9, 2);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('BRCR11', 'BRCR11', '2010-07-15', 9, 2);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('SDIL11', 'SDIL11', '2012-03-01', 9, 2);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('CVBI11', 'CVBI11', '2020-09-11', 10, 2);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('RZAG11', 'RZAG11', '2020-12-15', 6, 3);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('VGIR11', 'VGIR11', '2021-04-20', 6, 3);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('JGPX11', 'JGPX11', '2021-07-01', 6, 3);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('BTAL11', 'BTAL11', '2020-10-20', 6, 3);
INSERT INTO Ativo (NOME, TICKER, DATA_FUNDACAO, ID_SETOR, ID_TIPO_ATIVO) VALUES ('XPCI11', 'XPCI11', '2019-03-01', 10, 3);

-- Inserts para as cotações dos ativos
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (1, '2024-08-20 10:00:00', 30.50);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (2, '2024-08-20 10:00:00', 65.80);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (3, '2024-08-20 10:00:00', 14.75);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (4, '2024-08-20 10:00:00', 28.40);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (5, '2024-08-20 10:00:00', 23.90);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (6, '2024-08-20 10:00:00', 24.70);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (7, '2024-08-20 10:00:00', 19.20);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (8, '2024-08-20 10:00:00', 29.30);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (9, '2024-08-20 10:00:00', 25.40);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (10, '2024-08-20 10:00:00', 18.50);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (11, '2024-08-20 10:00:00', 15.60);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (12, '2024-08-20 10:00:00', 7.90);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (13, '2024-08-20 10:00:00', 42.80);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (14, '2024-08-20 10:00:00', 12.40);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (15, '2024-08-20 10:00:00', 23.70);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (16, '2024-08-20 10:00:00', 140.50);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (17, '2024-08-20 10:00:00', 160.30);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (18, '2024-08-20 10:00:00', 11.85);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (19, '2024-08-20 10:00:00', 112.75);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (20, '2024-08-20 10:00:00', 320.20);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (21, '2024-08-20 10:00:00', 110.50);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (22, '2024-08-20 10:00:00', 130.40);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (23, '2024-08-20 10:00:00', 115.25);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (24, '2024-08-20 10:00:00', 125.10);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (25, '2024-08-20 10:00:00', 105.75);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (26, '2024-08-20 10:00:00', 112.90);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (27, '2024-08-20 10:00:00', 119.60);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (28, '2024-08-20 10:00:00', 122.50);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (29, '2024-08-20 10:00:00', 118.30);
INSERT INTO Cotacao (ID_ATIVO, DATA, COTACAO) VALUES (30, '2024-08-20 10:00:00', 114.00);

