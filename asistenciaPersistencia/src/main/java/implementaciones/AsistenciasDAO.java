package implementaciones;

import entidades.Alumno;
import entidades.Asistencia;
import enumeradores.EstadoAsistencia;
import interfaces.IAsistenciasDAO;
import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AsistenciasDAO implements IAsistenciasDAO {

    private IConexionBD conexion;

    public AsistenciasDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Asistencia asistencia) {
        try {
            Connection con = conexion.obtenerConexion();
            PreparedStatement st = con.prepareStatement("INSERT INTO asistencias (id_alumno, fecha, estado) VALUES (?,?,?)");
            st.setString(1, asistencia.getId_alumno().toString());
            st.setString(2, asistencia.getFechaHoraRegistro().toString());
            st.setString(3, asistencia.getEstado().name());
            st.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean editar(Asistencia asistencia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(Asistencia asistencia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Alumno> consultaAlumnosPorGrupo(Long id_grupo){
        List<Alumno> listaAlumnos = new ArrayList<>();
        ResultSet result = null;
        String SQL = "SELECT e.matricula, e.nombre, e.apellido, e.correo FROM relGruposAlumnos g, alumnos e WHERE (g.id_alumno = e.id) AND (g.id_grupo = " + id_grupo.toString() + ");";
        try {
            Connection con = conexion.obtenerConexion();
            PreparedStatement st = con.prepareStatement(SQL);
            result = st.executeQuery();
            while (result.next()) {
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String matricula = result.getString("matricula");
                String correo = result.getString("correo");
                listaAlumnos.add(new Alumno(id_grupo, matricula, correo, nombre, apellido));
            }
            return listaAlumnos;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<Asistencia> consultarAsistenciasPorGrupo(Long id_grupo) {
        List<Asistencia> listaAsistencia = new ArrayList<>();
        ResultSet result = null;
        String SQL = "SELECT e.matricula, e.nombre, e.apellido, e.correo FROM relGruposAlumnos g, alumnos e WHERE (g.id_alumno = e.id) AND (g.id_grupo = " + id_grupo.toString() + ");";
        try {
            Connection con = conexion.obtenerConexion();
            PreparedStatement st = con.prepareStatement(SQL);
            result = st.executeQuery();
            while (result.next()) {
                Long id_asistencia = result.getLong("id_asistencia");
                Long id_alumno = result.getLong("id_asistencia");
                Date fechaHoraRegistro = result.getDate("fechaHoraRegistro");
                EstadoAsistencia estado = result.getObject("estado", EstadoAsistencia.class);
                listaAsistencia.add(new Asistencia(id_asistencia, id_alumno, id_grupo, fechaHoraRegistro, estado));
            }
            return listaAsistencia;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
