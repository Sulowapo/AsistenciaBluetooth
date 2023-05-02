package interfacescontrol;

import entidades.Alumno;
import java.util.List;


public interface IControlAlumnos {

    public boolean vincularDispositivoBluetooth(String matricula, String nombreDispositivo, String direccionBluetoothDispositivo);
    
    public boolean desvincularDispositivoBluetooth(String matricula);

    public boolean guardarAlumno(Alumno alumno);
    
    public boolean cambiarCorreoAlumno(String matricula, String correoNuevo);
    
    public boolean borrarAlumno(String matricula);
    
    public List<Alumno> consultarAlumnosPorGrupo(Long id_Grupo);

}
