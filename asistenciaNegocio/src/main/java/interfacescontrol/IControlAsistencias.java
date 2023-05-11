package interfacescontrol;

import entidades.Asistencia;
import java.util.List;

public interface IControlAsistencias {

    public boolean registrarAsistencia(Asistencia asistencia);
    
    public boolean actualizarAsistencia(Asistencia asistencia);

    public List<Asistencia> consultarAsistenciasPorGrupo(Long id_Grupo);
    
    public List<Asistencia> consultarAsistenciasGrupoPorFecha(Long id_grupo, String fecha);

    public List<Asistencia> consultarAsistenciasPorGrupoYalumno(Long id_grupo, Long id_alumno);
    
    public boolean verificarExistenciaAsistencia(Long id_Grupo, String fecha);
}
