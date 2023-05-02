package implementaciones;

import interfaces.IConexionBD;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD implements IConexionBD {

    private Connection conexion;

    public ConexionBD() {
    }
    
    @Override
    public Connection obtenerConexion() throws SQLException {
        String url = "src/main/java/asistencia.db";
        try {
            if (conexion == null) {
                conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            }
        } catch (SQLException ex) {
            
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }
        return conexion;
    }
}
