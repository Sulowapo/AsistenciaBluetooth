/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import entidades.Alumno;
import interfaces.IAlumnosDAO;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Maste
 */
public class AlumnosDAOTest {
    
    public AlumnosDAOTest() {
    }

    /**
     * Test of agregar method, of class AlumnosDAO.
     */
    @Test
    public void testAgregar() {
        System.out.println("agregar");
        Alumno alumno = new Alumno("229256", "saul.reyna229256@potros.itson.edu.mx", "Saúl Armando", "Reyna López");
        IAlumnosDAO instance = DAOSFactory.creaAlumnosDAO();
        boolean expResult = true;
        boolean result = instance.agregar(alumno);
        assertEquals(expResult, result);
        fail("No jala esta madre todavia");
    }

    /**
     * Test of actualizar method, of class AlumnosDAO.
     */
    @Test
    public void testActualizar() {
        System.out.println("actualizar");
        Alumno alumno = null;
        AlumnosDAO instance = null;
        boolean expResult = false;
        boolean result = instance.actualizar(alumno);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class AlumnosDAO.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        Long alumno_id = null;
        AlumnosDAO instance = null;
        boolean expResult = false;
        boolean result = instance.eliminar(alumno_id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarTodos method, of class AlumnosDAO.
     */
    @Test
    public void testConsultarTodos() {
        System.out.println("consultarTodos");
        AlumnosDAO instance = null;
        List<Alumno> expResult = null;
        List<Alumno> result = instance.consultarTodos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
