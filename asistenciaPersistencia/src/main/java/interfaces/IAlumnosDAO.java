
package interfaces;

import entidades.Alumno;
import java.util.List;

public interface IAlumnosDAO {
    public boolean agregar(Alumno alumno);
    public boolean editar(Alumno alumno);
    public boolean eliminar(Alumno alumno);
    public Alumno consultarAlumnoPorId(Long id);
    public List<Alumno> consultarAlumnosPorId(Long id);
    public List<Alumno> consultarAlumnosPorNombre(String nombre);
    public List<Alumno> consultarAlumnosPorGrupo(Long id_grupo);
}
