package br.edu.uniceub.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; 

public class Database {

    public static void main(String[] args) {
        // URL do banco de dados H2 (em memória)
        String jdbcUrl = "jdbc:h2:mem:banco";
        String username = "sa";
        String password = "password";

//        String jdbcUrl = "jdbc:h2:file:./data/testdb";
       

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement()) {

            String sqlCreateTable = "CREATE TABLE IF NOT EXISTS users (" +
                                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                                    "name VARCHAR(255) NOT NULL, " +
                                    "email VARCHAR(255) NOT NULL)";
            statement.execute(sqlCreateTable);

            System.out.println("Tabela 'users' criada com sucesso!");

            // Inserir dados na tabela
            String sqlInsert = "INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com')";
            statement.execute(sqlInsert);

            System.out.println("Dados inseridos com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
