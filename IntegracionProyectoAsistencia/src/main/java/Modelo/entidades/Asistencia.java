
package Modelo.entidades;

import Modelo.enumeradores.EstadoAsistencia;
import java.util.Date;

public class Asistencia {

    private Long id_asistencia;

    private Long id_alumno;

    private Long id_grupo;

    private Date fechaHoraRegistro;

    private EstadoAsistencia estado;

    public Asistencia() {
    }

    public Asistencia(Long id_asistencia, Long id_alumno, Long id_grupo, Date fechaHoraRegistro, EstadoAsistencia estado) {
        this.id_asistencia = id_asistencia;
        this.id_alumno = id_alumno;
        this.id_grupo = id_grupo;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.estado = estado;
    }

    public Long getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(Long id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public Long getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Long id_alumno) {
        this.id_alumno = id_alumno;
    }

    public Long getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(Long id_grupo) {
        this.id_grupo = id_grupo;
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
        hash += (id_asistencia != null ? id_asistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.id_asistencia == null && other.id_asistencia != null) || (this.id_asistencia != null && !this.id_asistencia.equals(other.id_asistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Asistencia[ id=" + id_asistencia + " ]";
    }
}
