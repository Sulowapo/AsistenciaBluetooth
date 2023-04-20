package implementaciones;

import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD implements IConexionBD {

    private Connection conexion;

    @Override
    public Connection obtenerConexion() throws SQLException {
        try {
            if (conexion == null) {
                conexion = DriverManager.getConnection("jdbc:sqlite:asistencia.db");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }
        return conexion;
    }
}
