/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import entidades.Asistencia;
import implementaciones.AsistenciasDAO;
import enumeradores.EstadoAsistencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pache
 */
public class ControlAsistencia implements IControlAsistencias {

    private List<Asistencia> asistencias = new ArrayList<>();

    @Override
    public boolean ponerAsistencia(Asistencia asistencia) {
        asistencia.setEstado(EstadoAsistencia.PRESENTE);
        return asistencias.add(asistencia);
    }

    @Override
    public boolean ponerFalta(Asistencia asistencia) {
        asistencia.setEstado(EstadoAsistencia.FALTA);
        return asistencias.add(asistencia);
    }

    @Override
    public boolean ponerJustificacion(Asistencia asistencia) {
        asistencia.setEstado(EstadoAsistencia.JUSTIFICADO);
        return asistencias.add(asistencia);
    }

    @Override
    public boolean ponerRetardo(Asistencia asistencia) {
        asistencia.setEstado(EstadoAsistencia.RETARDO);
        return asistencias.add(asistencia);
    }

    @Override
    public List<Asistencia> consultarAsistenciasPorGrupo(Long id_Grupo) {
        List<Asistencia> asistenciasPorGrupo = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getId_grupo().equals(id_Grupo)) {
                asistenciasPorGrupo.add(asistencia);
            }
        }
        return asistenciasPorGrupo;
    }
}
