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
            String sql =
                    //Tabla de alumnos
                      "CREATE TABLE alumnos "
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + " nombre TEXT NOT NULL, "
                    + " apellido TEXT NOT NULL, "
                    + " correo TEXT, "
                    + " dispositivoBluetoothNombre TEXT, "
                    + " dispositivoBlietoothAdress TEXT); "
                    //Tabla de grupos
                    + "CREATE TABLE grupos "
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + " nombreClase TEXT NOT NULL, "
                    + " horaInicio TEXT NOT NULL, "
                    + " horaFin TEXT NOT NULL); "
                    //Tabla de asistencias
                    + "CREATE TABLE asistencias "
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + " id_alumno INTEGER, "
                    + " id_grupo INTEGER, "
                    + " fechaHoraRegistro TEXT, "
                    + " estado TEXT NOT NULL, "
                    + " FOREIGN KEY(id_grupo) REFERENCES grupos(id), "
                    + " FOREIGN KEY(id_alumno) REFERENCES alumnos(id)); "
                    //Tabla de relGruposAlumnos
                    + " CREATE TABLE relGruposAlumnos "
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + " id_alumno INTEGER, "
                    + " id_grupo INTEGER, "
                    + " FOREIGN KEY(id_alumno) REFERENCES alumnos(id), "
                    + " FOREIGN KEY(id_grupo) REFERENCES grupos(id));";
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
