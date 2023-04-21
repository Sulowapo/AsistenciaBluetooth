package interfaces;

import entidades.Alumno;
import java.util.List;

/**
 *
 * @author pache
 */
public interface IControlAlumnos {

    boolean agregar(Alumno alumno);

    boolean actualizar(Alumno alumno);

    boolean eliminar(Long alumno_id);

    List<Alumno> consultarTodos();

}
