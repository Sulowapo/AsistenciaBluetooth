package Modelo.interfaces;

import entidades.Asistencia;
import java.util.List;

public interface IControlAsistencias {

    public boolean ponerAsistencia(Asistencia asistencia);

    public boolean ponerFalta(Asistencia asistencia);

    public boolean ponerJustificacion(Asistencia asistencia);
    
    public boolean ponerRetardo(Asistencia asistencia);

    public List<Asistencia> consultarAsistenciasPorGrupo(Long id_Grupo);

}
