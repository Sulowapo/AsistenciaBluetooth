
package entidades;

import java.sql.Timestamp;

public class Grupo {
    private Long id_grupo;

    private String nombreClase;

    private String horaInicio;

    private String horaFin;

    public Grupo() {
    }

    public Grupo(Long id_grupo, String nombreClase, String horaInicio, String horaFin) {
        this.id_grupo = id_grupo;
        this.nombreClase = nombreClase;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Long getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(Long id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_grupo != null ? id_grupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.id_grupo == null && other.id_grupo != null) || (this.id_grupo != null && !this.id_grupo.equals(other.id_grupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Grupo[ id=" + id_grupo + " ]";
    }
}
