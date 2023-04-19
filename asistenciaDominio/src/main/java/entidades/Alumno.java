/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.List;

public class Alumno {
    private Long alumno_id;

    private String matricula_alumno;

    private String correo_alumno;

    private String nombre;

    private String apellido;

    private String dispositivoBluetooth;

    private List<Asistencia> asistencias;

    public Alumno() {
    }

    public Alumno(Long alumno_id, String matricula_alumno, String correo_alumno, String nombre, String apellido, String dispositivoBluetooth, List<Asistencia> asistencias) {
        this.alumno_id = alumno_id;
        this.matricula_alumno = matricula_alumno;
        this.correo_alumno = correo_alumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dispositivoBluetooth = dispositivoBluetooth;
        this.asistencias = asistencias;
    }

    public Long getAlumno_id() {
        return alumno_id;
    }

    public void setAlumno_id(Long alumno_id) {
        this.alumno_id = alumno_id;
    }

    public String getMatricula_alumno() {
        return matricula_alumno;
    }

    public void setMatricula_alumno(String matricula_alumno) {
        this.matricula_alumno = matricula_alumno;
    }

    public String getCorreo_alumno() {
        return correo_alumno;
    }

    public void setCorreo_alumno(String correo_alumno) {
        this.correo_alumno = correo_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDispositivoBluetooth() {
        return dispositivoBluetooth;
    }

    public void setDispositivoBluetooth(String dispositivoBluetooth) {
        this.dispositivoBluetooth = dispositivoBluetooth;
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
        hash += (alumno_id != null ? alumno_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the alumno_id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.alumno_id == null && other.alumno_id != null) || (this.alumno_id != null && !this.alumno_id.equals(other.alumno_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Alumnos[ id=" + alumno_id + " ]";
    }
}
