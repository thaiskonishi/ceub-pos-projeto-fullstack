
                    SET SCHEMA dbFinancas;

                    CREATE TABLE SETOR (
                        ID INT PRIMARY KEY ,
                        NOME_SETOR VARCHAR(45) NOT NULL,
                        DESCRICAO VARCHAR(400) NULL,
                        CONSTRAINT NOME_SETOR_UNIQUE UNIQUE (NOME_SETOR)
                    );

                    CREATE TABLE TIPO_ATIVO (
                        ID INT PRIMARY KEY ,
                        NOME_TIPO_ATIVO VARCHAR(45) NOT NULL,
                        DESCRICAO VARCHAR(400) NULL
                    );


                    SET SCHEMA dbFinancas;
                    CREATE TABLE ATIVO (
                        ID INT PRIMARY KEY ,
                        NOME VARCHAR(45) NOT NULL,
                        TICKER VARCHAR(45) NOT NULL ,
                        DATA_FUNDACAO DATE NOT NULL,
                        ID_SETOR INT NOT NULL,
                        ID_TIPO_ATIVO INT NOT NULL,
                        FOREIGN KEY (ID_SETOR) REFERENCES SETOR(ID),
                        FOREIGN KEY (ID_TIPO_ATIVO) REFERENCES TIPO_ATIVO(ID)
                    );


                    CREATE TABLE COTACAO (
                        ID INT PRIMARY KEY ,
                        ID_ATIVO INT NOT NULL,
                        DATA TIMESTAMP NOT NULL,
                        COTACAO FLOAT NOT NULL,
                        FOREIGN KEY (ID_ATIVO) REFERENCES ATIVO(ID)
                    );

                    CREATE TABLE HISTORICO_COTACAO (
                        ID INT PRIMARY KEY ,
                        ID_ATIVO INT NOT NULL,
                        DATA TIMESTAMP NOT NULL,
                        COTACAO FLOAT NOT NULL
                    );