/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.*;

public class DAOSFactory {
    private static final IConexionBD conexion = new ConexionBD();
    
    public static IAlumnosDAO creaAlumnosDAO(){
        return new AlumnosDAO(conexion);
    }
    
    public static IAsistenciasDAO creaAsistenciasDAO(){
        return new AsistenciasDAO(conexion);
    }
    
    public static IGruposDAO creaGruposDAO(){
        return new GruposDAO(conexion);
    }
}
