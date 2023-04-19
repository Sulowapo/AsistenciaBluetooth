package interfaces;

import entidades.Maestro;
import java.util.List;

public interface IMaestrosDAO {
    
    boolean agregar(Maestro maestro);
   
    boolean actualizar(Maestro maestro);
    
    boolean eliminar(Long maestro_id);
        
    List<Maestro> consultarTodos();
    
}
