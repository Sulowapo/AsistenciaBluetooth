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

    List<Alumno> consultarPorId(Long alumno_id);

    List<Alumno> consultarPorMatricula(String matricula_alumno);

    List<Alumno> consultarPorNombre(Long alumno_id);

    List<Alumno> consultarPorApellido(Long alumno_id);

    List<Alumno> consultarTodos();

}
