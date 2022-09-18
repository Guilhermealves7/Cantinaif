/*
    Classe para facilitação a conexão em
    Outras partes do codigo que será 
    Preciso abrir um conexão com o banco.
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    // Para abrir a conexão
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/cantina", "root", "");
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
           
    }
    // Para fechar a conexão
    public static void closeConnection(Connection c){
        try {
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}