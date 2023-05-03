package implementaciones;

import entidades.Alumno;
import interfaces.IAlumnosDAO;
import interfaces.IConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnosDAO implements IAlumnosDAO {

    private IConexionBD conexion;
    Connection con;
    
    public AlumnosDAO(IConexionBD conexion) {
        this.conexion = conexion;
        new DataBase(conexion).verificarBaseDeDatos();
    }

    @Override
    public boolean agregar(Alumno alumno) {
        try {
            con = conexion.obtenerConexion();
            PreparedStatement st = con.prepareStatement("INSERT INTO alumnos (nombre, apellido, matricula) VALUES (?,?,?)");
            st.setString(1, alumno.getNombre());
            st.setString(2, alumno.getApellido());
            st.setString(3, alumno.getMatricula_alumno());
            st.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean editar(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> consultarAlumnosPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Alumno consultarAlumnoPorId(Long id) {
        try {
            con = conexion.obtenerConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM alumnos WHERE id = ?");
            ps.setLong(1, id);
            ResultSet result = ps.executeQuery();
            String matricula = result.getString("matricula");
            String nombre = result.getString("nombre");
            String apellido = result.getString("apellido");
            String correo = result.getString("correo");
            return new Alumno(id, matricula, correo, nombre, apellido);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Este metodo consulta a los alumnos de un grupo por su nombre
     *
     * @param nombre del alumno
     * @return la lista de alumnos que coincidan con el nombre ingresado.
     */
    @Override
    public List<Alumno> consultarAlumnosPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> consultarAlumnosPorGrupo(Long id_grupo) {
        List<Alumno> listaAlumnos = new ArrayList<>();
        try {
            con = conexion.obtenerConexion();
            PreparedStatement ps = con.prepareStatement("SELECT a.id as id_Alumno, a.matricula as matricula_Alumno, a.nombre as nombre_Alumno, a.apellido as apellido_Alumno, a.correo as correo_Alumno, a.dispositivoBluetoothNombre as bluetoothNombre, a.dispositivoBlietoothAdress as bluetoothAdress FROM alumnos AS a INNER JOIN relGruposAlumnos AS r ON r.id_alumno = a.id WHERE r.id_grupo = ? ORDER BY apellido_Alumno ASC");
            ps.setLong(1, id_grupo);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Long id = result.getLong("id_Alumno");
                String matricula = result.getString("matricula_Alumno");
                String nombre = result.getString("nombre_Alumno");
                String apellido = result.getString("apellido_Alumno");
                String correo = result.getString("correo_Alumno");
                String nombreBluetooth = result.getString("bluetoothNombre");
                String direccionBluetooth = result.getString("bluetoothAdress");
                listaAlumnos.add(new Alumno(id, matricula, correo, nombre, apellido, nombreBluetooth, direccionBluetooth));
            }
            return listaAlumnos;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
