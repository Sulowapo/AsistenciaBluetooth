package interfaces;

import entidades.Asistencia;
import java.util.List;

/**
 *
 * @author pache
 */
public interface IControlAsistencias {

    boolean agregar(Asistencia asistencia);

    boolean actualizar(Asistencia asistencia);

    boolean eliminar(Long asistencia_id);

    List<Asistencia> consultar(Long asistencia_id);

    List<Asistencia> consultarPorPeriodo(Long asistencia_id);

    List<Asistencia> consultarTodos();

}
