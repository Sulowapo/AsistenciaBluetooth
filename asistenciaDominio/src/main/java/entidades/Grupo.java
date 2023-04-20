/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.sql.Timestamp;
import java.util.List;

public class Grupo {
    private Long id_grupo;

    private String nombreClase;

    private Timestamp horaInicio;

    private Timestamp horaFin;

    private List<Long> id_alumnos;

    public Grupo() {
    }

    public Grupo(Long id_grupo, String nombreClase, Timestamp horaInicio, Timestamp horaFin, List<Long> id_alumnos) {
        this.id_grupo = id_grupo;
        this.nombreClase = nombreClase;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.id_alumnos = id_alumnos;
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

    public List<Long> getId_alumnos() {
        return id_alumnos;
    }

    public void setId_alumnos(List<Long> id_alumnos) {
        this.id_alumnos = id_alumnos;
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
