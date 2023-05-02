package entidades;

import enumeradores.EstadoAsistencia;
import java.util.Date;

public class Asistencia {

    private Long id_asistencia;

    private Long id_alumno;

    private Long id_grupo;

    private String fechaHoraRegistro;

    private String estado;

    public Asistencia() {
    }

    public Asistencia(Long id_asistencia, Long id_alumno, Long id_grupo, String fechaHoraRegistro, String estado) {
        this.id_asistencia = id_asistencia;
        this.id_alumno = id_alumno;
        this.id_grupo = id_grupo;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.estado = estado;
    }

    public Asistencia(Long id_alumno, Long id_grupo, String fechaHoraRegistro, String estado) {
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

    public String getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(String fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
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
