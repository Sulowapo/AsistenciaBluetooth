
package control;

import interfaces.IConexionBD;
import interfacescontrol.IControlGrupos;

public class ControlGrupos implements IControlGrupos {
    
    private IConexionBD conexion;

    public ControlGrupos(IConexionBD conexion) {
        this.conexion = conexion;
    }

    
}
