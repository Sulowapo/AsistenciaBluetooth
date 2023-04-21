
package interfaces;

import entidades.Asistencia;
import implementaciones.AsistenciasDAO;
import enumeradores.EstadoAsistencia;
import java.util.ArrayList;
import java.util.List;

public class ControlAsistencia implements IControlAsistencias {

    IConexionBD conexion;

    public ControlAsistencia(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public boolean ponerAsistencia(Asistencia asistencia) {
        return new AsistenciasDAO(conexion).agregar(asistencia);
    }

    @Override
    public boolean ponerFalta(Asistencia asistencia) {
        return new AsistenciasDAO(conexion).agregar(asistencia);
    }

    @Override
    public boolean ponerJustificacion(Asistencia asistencia) {
        return new AsistenciasDAO(conexion).agregar(asistencia);
    }

    @Override
    public boolean ponerRetardo(Asistencia asistencia) {
        return new AsistenciasDAO(conexion).agregar(asistencia);
    }

    @Override
    public List<Asistencia> consultarAsistenciasPorGrupo(Long id_Grupo) {
        return new AsistenciasDAO(conexion).consultarAsistenciasPorGrupo(id_Grupo);
    }
}
