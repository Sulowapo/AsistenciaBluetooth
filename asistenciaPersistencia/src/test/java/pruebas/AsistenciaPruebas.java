
package pruebas;

import implementaciones.ConexionBD;
import implementaciones.AsistenciasDAO;
import java.sql.Connection;
import java.sql.SQLException;

public class AsistenciaPruebas {

    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        Connection con = new ConexionBD().obtenerConexion();        
        
    }
    
}
