/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Alumno;
import interfaces.IAlumnosDAO;
import interfaces.IConexionBD;
import java.util.List;
import javax.persistence.EntityManager;

public class AlumnosDAO implements IAlumnosDAO{

    private final IConexionBD conexion;

    public AlumnosDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Alumno alumno) {
        try {
            EntityManager em = this.conexion.obtenerConexion();
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException ex) {
            System.err.println("No se pudo agregar al alumno");
            return false;
        }
    }

    @Override
    public boolean actualizar(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(Long alumno_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
