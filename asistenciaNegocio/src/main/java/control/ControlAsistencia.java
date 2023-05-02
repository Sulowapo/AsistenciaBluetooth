
package control;

import entidades.Asistencia;
import implementaciones.AsistenciasDAO;
import interfaces.IConexionBD;
import interfacescontrol.IControlAsistencias;
import java.util.List;

public class ControlAsistencia implements IControlAsistencias {

    private AsistenciasDAO dao;

    public ControlAsistencia(IConexionBD conexion) {
        this.dao = new AsistenciasDAO(conexion);
    }
    
    @Override
    public boolean registrarAsistencia(Asistencia asistencia) {
        return dao.agregar(asistencia);
    }

    @Override
    public boolean actualizarAsistencia(Asistencia asistencia) {
        return dao.editar(asistencia);
    }
    
    @Override
    public List<Asistencia> consultarAsistenciasPorGrupo(Long id_Grupo) {
        return dao.consultarAsistenciasPorGrupo(id_Grupo);
    }

    @Override
    public boolean verificarExistenciaAsistencia(Long id_Grupo, String fecha) {
        List<Asistencia> listaAsistencia = dao.consultarAsistenciasPorFechaYGrupo(fecha, id_Grupo);
        return listaAsistencia.size() == 0;
    }

}
