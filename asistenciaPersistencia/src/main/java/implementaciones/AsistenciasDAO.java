package implementaciones;

import entidades.Asistencia;
import interfaces.IAsistenciasDAO;
import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AsistenciasDAO implements IAsistenciasDAO {

    private IConexionBD conexion;
    Connection con;

    public AsistenciasDAO(IConexionBD conexion) {
        this.conexion = conexion;
        new DataBase(conexion).verificarBaseDeDatos();
    }

    @Override
    public boolean agregar(Asistencia asistencia) {
        try {
            con = conexion.obtenerConexion();
            PreparedStatement st = con.prepareStatement("INSERT INTO asistencias (id_alumno, id_grupo, fechaHoraRegistro, estado) VALUES (?,?,?,?)");
            st.setString(1, asistencia.getId_alumno().toString());
            st.setString(2, asistencia.getId_grupo().toString());
            st.setString(3, asistencia.getFechaHoraRegistro());
            st.setString(4, asistencia.getEstado());
            st.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean editar(Asistencia asistencia) {
        try {
            con = conexion.obtenerConexion();
            PreparedStatement st = con.prepareStatement("UPDATE asistencias SET estado = ? WHERE id_grupo = ? AND  id_Alumno = ? AND fechaHoraRegistro = ?;");
            st.setString(1, asistencia.getEstado());
            st.setString(2, asistencia.getId_grupo().toString());
            st.setString(3, asistencia.getId_alumno().toString());
            st.setString(4, asistencia.getFechaHoraRegistro());
            st.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(Asistencia asistencia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Asistencia> consultarAsistenciasPorGrupo(Long id_grupo) {
        List<Asistencia> listaAsistencia = new ArrayList<>();
        ResultSet result = null;
        String SQL = "SELECT id AS id_asistencia, id_alumno, fechaHoraRegistro, estado FROM asistencias WHERE id_grupo = " + id_grupo.toString() + ";";
        try {
            con = conexion.obtenerConexion();
            PreparedStatement st = con.prepareStatement(SQL);
            result = st.executeQuery();
            while (result.next()) {
                Long id_asistencia = result.getLong("id_asistencia");
                Long id_alumno = result.getLong("id_alumno");
                String fechaHoraRegistro = result.getString("fechaHoraRegistro");
                String estado = result.getString("estado");
                listaAsistencia.add(new Asistencia(id_asistencia, id_alumno, id_grupo, fechaHoraRegistro, estado));
            }
            return listaAsistencia;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Asistencia> consultarAsistenciasPorFechaYGrupo(String fecha, Long id_Grupo) {
        List<Asistencia> listaAsistencia = new ArrayList<>();
        ResultSet result = null;
        String SQL = "SELECT id, id_alumno, id_grupo, fechaHoraRegistro, estado FROM asistencias WHERE id_grupo = " + id_Grupo.toString() + " AND fechaHoraRegistro = '" + fecha + "';";
        try {
            con = conexion.obtenerConexion();
            PreparedStatement st = con.prepareStatement(SQL);
            result = st.executeQuery();
            while (result.next()) {
                System.out.println("no está vacia la lista de asistencia");
                Long id_asistencia = result.getLong("id");
                Long id_alumno = result.getLong("id_alumno");
                String fechaHoraRegistro = result.getString("fechaHoraRegistro");
                String estado = result.getString("estado");
                listaAsistencia.add(new Asistencia(id_asistencia, id_alumno, id_Grupo, fechaHoraRegistro, estado));
            }
            return listaAsistencia;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Asistencia> consultarFechasAsistenciasPorGrupo(Long id_grupo) {
        List<Asistencia> listaAsistencia = new ArrayList<>();
        ResultSet result = null;
        String SQL = "SELECT asistencias.fechaHoraRegistro AS fecha_asistencia FROM asistencias WHERE asistencias.id_grupo = " + id_grupo.toString() + " GROUP BY asistencias.fechaHoraRegistro";
        try {
            con = conexion.obtenerConexion();
            PreparedStatement st = con.prepareStatement(SQL);
            result = st.executeQuery();
            while (result.next()) {
                String fechaHoraRegistro = result.getString("fecha_asistencia");
                listaAsistencia.add(new Asistencia(id_grupo, fechaHoraRegistro));
            }
            return listaAsistencia;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Asistencia> consultarFechasAsistenciasAlumnoPorGrupo(Long id_grupo, Long id_alumno) {
        List<Asistencia> listaAsistencia = new ArrayList<>();
        ResultSet result = null;
        String SQL = "SELECT asistencias.id AS id_asistencia, asistencias.fechaHoraRegistro AS fecha_asistencia, asistencias.estado AS estado_asistencia "
                + "FROM asistencias "
                + "WHERE asistencias.id_grupo = " + id_grupo.toString() + " AND asistencias.id_alumno = " + id_alumno.toString();
        try {
            con = conexion.obtenerConexion();
            PreparedStatement st = con.prepareStatement(SQL);
            result = st.executeQuery();
            while (result.next()) {
                Long id_asistencia = result.getLong("id_asistencia");
                String fechaHoraRegistro = result.getString("fecha_asistencia");
                String estado = result.getString("estado_asistencia");
                listaAsistencia.add(new Asistencia(id_asistencia, id_alumno, id_grupo, fechaHoraRegistro, estado));
            }
            return listaAsistencia;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
