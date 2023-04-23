/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.entidades;

public class Alumno {

    private Long id_alumno;

    private String matricula_alumno;

    private String correo_alumno;

    private String nombre;

    private String apellido;

    private String dispositivoBluetoothNombre;

    private String dispositivoBluetoothDireccion;
    
    public Alumno() {
    }

    public Alumno(Long id_alumno, String matricula_alumno, String correo_alumno, String nombre, String apellido, String dispositivoBluetoothNombre, String dispositivoBluetoothDireccion) {
        this.id_alumno = id_alumno;
        this.matricula_alumno = matricula_alumno;
        this.correo_alumno = correo_alumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dispositivoBluetoothNombre = dispositivoBluetoothNombre;
        this.dispositivoBluetoothDireccion = dispositivoBluetoothDireccion;
    }

    public Long getAlumno_id() {
        return id_alumno;
    }

    public void setId_alumno(Long id_alumno) {
        this.id_alumno = id_alumno;
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

    public String getDispositivoBluetoothNombre() {
        return dispositivoBluetoothNombre;
    }

    public void setDispositivoBluetoothNombre(String dispositivoBluetoothNombre) {
        this.dispositivoBluetoothNombre = dispositivoBluetoothNombre;
    }

    public String getDispositivoBluetoothDireccion() {
        return dispositivoBluetoothDireccion;
    }

    public void setDispositivoBluetoothDireccion(String dispositivoBluetoothDireccion) {
        this.dispositivoBluetoothDireccion = dispositivoBluetoothDireccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_alumno != null ? id_alumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the alumno_id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.id_alumno == null && other.id_alumno != null) || (this.id_alumno != null && !this.id_alumno.equals(other.id_alumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Alumnos[ id=" + id_alumno + " ]";
    }
}
