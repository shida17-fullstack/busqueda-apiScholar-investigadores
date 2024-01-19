package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnect {
    // Configuración de la conexión
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ScholarAuthor";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Obtener la conexión
            return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al conectar a la base de datos");
        }
    }
    
   
}
