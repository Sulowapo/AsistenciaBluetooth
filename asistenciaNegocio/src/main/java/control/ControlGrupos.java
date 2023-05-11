
package control;

import entidades.Grupo;
import implementaciones.GruposDAO;
import interfaces.IConexionBD;
import interfacescontrol.IControlGrupos;
import java.util.List;

public class ControlGrupos implements IControlGrupos {
    
    private GruposDAO dao;

    public ControlGrupos(IConexionBD conexion) {
        this.dao = new GruposDAO(conexion);
    }

    @Override
    public List<Grupo> consultarGrupos(){
        return dao.consultarGrupos();
    }
}
