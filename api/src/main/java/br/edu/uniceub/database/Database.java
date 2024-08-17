package br.edu.uniceub.database;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

import org.h2.tools.Server; 

public class Database {

    public static void main(String[] args) {

        try {
            
            Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
            String jdbcUrl = "jdbc:h2:~/test";
            String username = "sa";
            String password = "sa";
       

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement()) {

            /* String sqlCreateTable = "CREATE TABLE IF NOT EXISTS users (" +
                                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                                    "name VARCHAR(255) NOT NULL, " +
                                    "email VARCHAR(255) NOT NULL)";
            statement.execute(sqlCreateTable);


            System.out.println("Tabela 'users' criada com sucesso!");

            // Inserir dados na tabela
            String sqlInsert = "INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com')";
            statement.execute(sqlInsert);

            System.out.println("Dados inseridos com sucesso!");
*/
                                String sqlScript = 
                   "CREATE SCHEMA dbFinancas;" +
                   "SET SCHEMA dbFinancas;" +

                   "CREATE SEQUENCE Seq_ID START WITH 1 INCREMENT BY 1;" +

                 //"CREATE DATABASE DBFINANCAS;"+
                   // "DROP TABLE IF EXISTS SETOR;" +
                    "CREATE TABLE SETOR (" +
                    "    ID INT PRIMARY KEY," +
                    "    NOME_SETOR VARCHAR(45) NOT NULL," +
                    "    DESCRICAO VARCHAR(400) NULL," +
                    ");" +


                    //"DROP TABLE IF EXISTS TIPO_ATIVO;" +
                    "CREATE TABLE TIPO_ATIVO (" +
                    "    ID INT PRIMARY KEY ," +
                    "    NOME_TIPO_ATIVO VARCHAR(45) NOT NULL," +
                    "    DESCRICAO VARCHAR(400) NULL," +                 
                    ");" +

                //    "DROP TABLE IF EXISTS ATIVO;" +
                    "CREATE TABLE ATIVO (" +
                    "    ID INT PRIMARY KEY," +
                    "    NOME VARCHAR(45) NOT NULL," +
                    "    TICKER VARCHAR(45) NOT NULL UNIQUE," +
                    "    DATA_FUNDACAO DATE NOT NULL," +
                    "    ID_SETOR INT NOT NULL," +
                    "    ID_TIPO_ATIVO INT NOT NULL," +
                    "    FOREIGN KEY (ID_SETOR) REFERENCES SETOR(ID)," +
                    "    FOREIGN KEY (ID_TIPO_ATIVO) REFERENCES TIPO_ATIVO(ID)" +
                    ");" +

                //    "DROP TABLE IF EXISTS COTACAO;" +
                    "CREATE TABLE COTACAO (" +
                    "    ID INT PRIMARY KEY," +
                    "    ID_ATIVO INT NOT NULL," +
                    "    DATA TIMESTAMP NOT NULL," +
                    "    COTACAO FLOAT NOT NULL," +
                    "    FOREIGN KEY (ID_ATIVO) REFERENCES ATIVO(ID)" +
                    ");" +

                //    "DROP TABLE IF EXISTS HISTORICO_COTACAO;" +
                    "CREATE TABLE HISTORICO_COTACAO (" +
                    "    ID INT PRIMARY KEY," +
                    "    ID_ATIVO INT NOT NULL," +
                    "    DATA TIMESTAMP NOT NULL," +
                    "    COTACAO FLOAT NOT NULL" +
                    ");";

                statement.execute(sqlScript);

                System.out.println("Banco de dados configurado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    } catch (Exception e) {
        // TODO: handle exception
    }
    }
}
