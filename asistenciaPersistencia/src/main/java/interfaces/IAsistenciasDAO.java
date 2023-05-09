
package interfaces;

import entidades.Asistencia;
import java.util.List;

public interface IAsistenciasDAO {
    public boolean agregar(Asistencia asistencia);
    public boolean editar(Asistencia asistencia);
    public boolean eliminar(Asistencia asistencia);
    public List<Asistencia> consultarAsistenciasPorGrupo(Long id_grupo);
    public List<Asistencia> consultarAsistenciasPorFechaYGrupo(String fecha, Long id_Grupo);
    public List<Asistencia> consultarFechasAsistenciasPorGrupo(Long id_grupo);
    public List<Asistencia> consultarFechasAsistenciasAlumnoPorGrupo(Long id_grupo, Long id_alumno);
}
