package entidades;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author pache
 */
public class Grupo {

    private Long grupo_id;

    private String nombreClase;

    private Timestamp horaInicio;

    private Timestamp horaFin;

    private List<Alumno> alumnos;

    private List<Asistencia> asistencias;

    public Grupo() {
    }

    public Grupo(Long grupo_id, String nombreClase, Timestamp horaInicio, Timestamp horaFin, List<Alumno> alumnos, List<Asistencia> asistencias) {
        this.grupo_id = grupo_id;
        this.nombreClase = nombreClase;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.alumnos = alumnos;
        this.asistencias = asistencias;
    }

    public Long getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(Long grupo_id) {
        this.grupo_id = grupo_id;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public Timestamp getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Timestamp horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Timestamp getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Timestamp horaFin) {
        this.horaFin = horaFin;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupo_id != null ? grupo_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.grupo_id == null && other.grupo_id != null) || (this.grupo_id != null && !this.grupo_id.equals(other.grupo_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Grupo[ id=" + grupo_id + " ]";
    }

}
