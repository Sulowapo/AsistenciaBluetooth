
package control;

import entidades.Alumno;
import implementaciones.AlumnosDAO;
import interfaces.IAlumnosDAO;
import interfaces.IConexionBD;
import interfacescontrol.IControlAlumnos;
import java.util.List;

public class ControlAlumnos implements IControlAlumnos {

    private IConexionBD conexion;
    
    public ControlAlumnos(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean vincularDispositivoBluetooth(String matricula, String nombreDispositivo, String direccionBluetoothDispositivo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean desvincularDispositivoBluetooth(String matricula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean guardarAlumno(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean cambiarCorreoAlumno(String matricula, String correoNuevo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean borrarAlumno(String matricula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Alumno consultarAlumnoPorId(Long id_Alumno){
        IAlumnosDAO dao = new AlumnosDAO(conexion);
        try {
            return dao.consultarAlumnoPorId(id_Alumno);
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<Alumno> consultarAlumnosPorGrupo(Long id_Grupo) {
        IAlumnosDAO dao = new AlumnosDAO(conexion);
        try {
            return dao.consultarAlumnosPorGrupo(id_Grupo);
        } catch (Exception e) {
            return null;
        }
    }

}
