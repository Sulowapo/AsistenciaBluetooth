package interfaces;

import entidades.Asistencia;
import java.util.List;

public interface IAsistenciasDAO {

    boolean agregar(Asistencia asistencia);

    boolean actualizar(Asistencia asistencia);

    boolean eliminar(Long asistencia_id);

    List<Asistencia> consultarTodos();

}
