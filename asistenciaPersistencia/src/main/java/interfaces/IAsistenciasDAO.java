
package interfaces;

import entidades.Asistencia;
import java.util.List;

public interface IAsistenciasDAO {
    public boolean agregar(Asistencia asistencia);
    public boolean editar(Asistencia asistencia);
    public boolean eliminar(Asistencia asistencia);
    public List<Asistencia> consultarAsistenciaPorNombre(String nombre);
    public List<Asistencia> consultarTodos();
}
