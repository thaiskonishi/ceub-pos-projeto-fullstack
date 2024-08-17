-- SQL Server Script com Triggers para Auto-Incremento

-- -----------------------------------------------------
-- Schema dbFinancas
-- -----------------------------------------------------
IF EXISTS (SELECT * FROM sys.schemas WHERE name = 'dbFinancas')
BEGIN
    DROP SCHEMA dbFinancas;
END;
GO

IF EXISTS (SELECT * FROM sys.databases WHERE name = 'dbFinancas')
BEGIN
    DROP DATABASE dbFinancas;
END;
GO

CREATE SCHEMA dbFinancas;
GO

CREATE DATABASE dbFinancas;
GO

USE dbFinancas;
GO

-- -----------------------------------------------------
-- Sequence para Auto-Incremento
-- -----------------------------------------------------
CREATE SEQUENCE dbFinancas.Seq_ID
    AS INT
    START WITH 1
    INCREMENT BY 1;
GO

-- -----------------------------------------------------
-- Table dbFinancas.SETOR
-- -----------------------------------------------------
IF OBJECT_ID('dbFinancas.SETOR', 'U') IS NOT NULL 
BEGIN
    DROP TABLE dbFinancas.SETOR;
END;
GO

CREATE TABLE dbFinancas.SETOR (
    ID INT NOT NULL PRIMARY KEY DEFAULT NEXT VALUE FOR dbFinancas.Seq_ID,
    NOME_SETOR VARCHAR(45) NOT NULL,
    DESCRICAO VARCHAR(400) NULL,
    CONSTRAINT NOME_SETOR_UNIQUE UNIQUE (NOME_SETOR)
);
GO

-- -----------------------------------------------------
-- Table dbFinancas.TIPO_ATIVO
-- -----------------------------------------------------
IF OBJECT_ID('dbFinancas.TIPO_ATIVO', 'U') IS NOT NULL 
BEGIN
    DROP TABLE dbFinancas.TIPO_ATIVO;
END;
GO

CREATE TABLE dbFinancas.TIPO_ATIVO (
    ID INT NOT NULL PRIMARY KEY DEFAULT NEXT VALUE FOR dbFinancas.Seq_ID,
    NOME_TIPO_ATIVO VARCHAR(45) NOT NULL,
    DESCRICAO VARCHAR(400) NULL,
    CONSTRAINT NOME_TIPO_ATIVO_UNIQUE UNIQUE (NOME_TIPO_ATIVO)
);
GO

-- -----------------------------------------------------
-- Table dbFinancas.ATIVO
-- -----------------------------------------------------
IF OBJECT_ID('dbFinancas.ATIVO', 'U') IS NOT NULL 
BEGIN
    DROP TABLE dbFinancas.ATIVO;
END;
GO

CREATE TABLE dbFinancas.ATIVO (
    ID INT NOT NULL PRIMARY KEY DEFAULT NEXT VALUE FOR dbFinancas.Seq_ID,
    NOME VARCHAR(45) NOT NULL,
    TICKER VARCHAR(45) NOT NULL UNIQUE,
    DATA_FUNDACAO DATE NOT NULL,
    ID_SETOR INT NOT NULL,
    ID_TIPO_ATIVO INT NOT NULL,
    CONSTRAINT COD_SETOR_idx FOREIGN KEY (ID_SETOR) 
        REFERENCES dbFinancas.SETOR (ID) 
        ON DELETE NO ACTION 
        ON UPDATE NO ACTION,
    CONSTRAINT COD_TIPO_ATIVO_idx FOREIGN KEY (ID_TIPO_ATIVO) 
        REFERENCES dbFinancas.TIPO_ATIVO (ID) 
        ON DELETE NO ACTION 
        ON UPDATE NO ACTION
);
GO

-- -----------------------------------------------------
-- Table dbFinancas.COTACAO
-- -----------------------------------------------------
IF OBJECT_ID('dbFinancas.COTACAO', 'U') IS NOT NULL 
BEGIN
    DROP TABLE dbFinancas.COTACAO;
END;
GO

CREATE TABLE dbFinancas.COTACAO (
    ID INT NOT NULL PRIMARY KEY DEFAULT NEXT VALUE FOR dbFinancas.Seq_ID,
    ID_ATIVO INT NOT NULL,
    DATA DATETIME2(1) NOT NULL,
    COTACAO FLOAT NOT NULL,
    CONSTRAINT ID_ATIVO_FK FOREIGN KEY (ID_ATIVO) 
        REFERENCES dbFinancas.ATIVO (ID) 
        ON DELETE NO ACTION 
        ON UPDATE NO ACTION
);
GO

-- -----------------------------------------------------
-- Table dbFinancas.HISTORICO_COTACAO
-- -----------------------------------------------------
IF OBJECT_ID('dbFinancas.HISTORICO_COTACAO', 'U') IS NOT NULL 
BEGIN
    DROP TABLE dbFinancas.HISTORICO_COTACAO;
END;
GO

CREATE TABLE dbFinancas.HISTORICO_COTACAO (
    ID INT NOT NULL PRIMARY KEY DEFAULT NEXT VALUE FOR dbFinancas.Seq_ID,
    ID_ATIVO INT NOT NULL,
    DATA DATETIME2(1) NOT NULL,
    COTACAO FLOAT NOT NULL
);
GO
