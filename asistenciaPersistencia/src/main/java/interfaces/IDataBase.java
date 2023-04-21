package interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public interface IDataBase {

    public boolean crearBaseDeDatos();

    public class CrearTablaAlumnos {

        // Configuración de la conexión a la base de datos
        private static final String URL = "jdbc:sqlite:alumnos.db";

        public static void main(String[] args) {
            Connection conn = null;
            try {
                // Crear la conexión a la base de datos
                conn = DriverManager.getConnection(URL);

                // Crear la tabla "alumnos"
                Statement stmt = conn.createStatement();
                String sql = "CREATE TABLE alumnos "
                        + "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + " nombre VARCHAR(255), "
                        + " apellido VARCHAR(255), "
                        + " correo VARCHAR(255))";
                stmt.executeUpdate(sql);
                System.out.println("Tabla creada exitosamente");

                // Cerrar la conexión a la base de datos
                conn.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        public class InsertarAlumno {

            // Configuración de la conexión a la base de datos
            private static final String URL = "jdbc:sqlite:alumnos.db";

            public static void main(String[] args) {
                Connection conn = null;
                try {
                    // Crear la conexión a la base de datos
                    conn = DriverManager.getConnection(URL);

                    // Insertar un nuevo alumno
                    String sql = "INSERT INTO alumnos(nombre, apellido, correo) VALUES (?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, "Ricardo");
                    pstmt.setString(2, "saeta");
                    pstmt.setString(3, "Richard11@gmail.com");
                    pstmt.executeUpdate();
                    System.out.println("Alumno agregado exitosamente");

                    // Cerrar la conexión a la base de datos
                    conn.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
        }

    }

}
