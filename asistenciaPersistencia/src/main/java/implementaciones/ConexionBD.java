/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IConexionBD;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexionBD implements IConexionBD {

    
    
    @Override
    public Connection obtenerConexion() throws IllegalStateException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:AsistenciaBD.db");
            System.out.println("Conexión establecida con la base de datos SQLite.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

}
