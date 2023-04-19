package entidades;

import enumeradores.EstadoAsistencia;
import java.util.Date;

/**
 *
 * @author pache
 */
public class Asistencia {

    private Long asistencia_id;

    private Alumno alumno;

    private Grupo grupo;

    private Date fechaHoraRegistro;

    private EstadoAsistencia estado;

    public Asistencia() {
    }

    public Asistencia(Long asistencia_id, Alumno alumno, Grupo grupo, Date fechaHoraRegistro, EstadoAsistencia estado) {
        this.asistencia_id = asistencia_id;
        this.alumno = alumno;
        this.grupo = grupo;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.estado = estado;
    }

    public Long getAsistencia_id() {
        return asistencia_id;
    }

    public void setAsistencia_id(Long asistencia_id) {
        this.asistencia_id = asistencia_id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public EstadoAsistencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsistencia estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asistencia_id != null ? asistencia_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.asistencia_id == null && other.asistencia_id != null) || (this.asistencia_id != null && !this.asistencia_id.equals(other.asistencia_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Asistencia[ id=" + asistencia_id + " ]";
    }

}
