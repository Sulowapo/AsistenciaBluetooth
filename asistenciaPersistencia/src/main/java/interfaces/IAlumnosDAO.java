
package interfaces;

import entidades.Alumno;
import java.util.List;

public interface IAlumnosDAO {
    public boolean agregar(Alumno asistencia);
    public boolean editar(Alumno asistencia);
    public boolean eliminar(Alumno asistencia);
    public List<Alumno> consultarAsistenciaPorNombre(String nombre);
    public List<Alumno> consultarTodos();
}
