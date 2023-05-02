package implementaciones;

import interfaces.IConexionBD;
import interfaces.IDataBase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase implements IDataBase {

    private IConexionBD conexion;

    public DataBase(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public void verificarBaseDeDatos(){
        File file = new File("src/main/java/asistencia.db");
 
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            if (br.readLine() == null) {
                crearBaseDeDatos();
            }
        } catch (IOException e) {
            System.out.println("No se pudo verificar la base de datos");
        }
    }
    
    private boolean crearBaseDeDatos() {
        try {
            Connection con = conexion.obtenerConexion();
            Statement stmt = con.createStatement();
            String sql =
                    //Tabla de alumnos
                      "CREATE TABLE alumnos "
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + " nombre TEXT NOT NULL, "
                    + " matricula TEXT NOT NULL, "
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
    
    
//    public static void main(String[] args) {
//       new DataBase(new ConexionBD()).crearBaseDeDatos();
//    }
}
