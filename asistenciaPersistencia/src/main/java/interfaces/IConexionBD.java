
package interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConexionBD {
    public Connection obtenerConexion() throws SQLException;
}
