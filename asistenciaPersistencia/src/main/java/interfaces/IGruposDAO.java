package interfaces;

import entidades.Grupo;
import java.util.List;

public interface IGruposDAO {

    boolean agregar(Grupo grupo);

    boolean actualizar(Grupo grupo);

    boolean eliminar(Long grupo_id);

    List<Grupo> consultarTodos();

}
