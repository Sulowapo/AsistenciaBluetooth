package implementaciones;

import entidades.Asistencia;
import interfaces.IConexionBD;
import interfaces.IDataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase implements IDataBase {

    private IConexionBD conexion;

    public DataBase(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean crearBaseDeDatos() {
        try {
            Connection con = conexion.obtenerConexion();
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE alumnos "
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + " nombre VARCHAR(255), "
                    + " apellido VARCHAR(255), "
                    + " correo VARCHAR(255"
                    + " dispositivo

            stmt.executeUpdate(sql);
            System.out.println("Tabla creada exitosamente");
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }
    
    public static void main(String[] args) {
       new DataBase(new ConexionBD()).crearBaseDeDatos();
    }
}
