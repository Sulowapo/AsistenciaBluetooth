package interfaces;

import entidades.Grupo;
import java.util.List;

/**
 *
 * @author pache
 */
public interface IControlGrupos {

    boolean agregar(Grupo grupo);

    boolean actualizar(Grupo grupo);

    boolean eliminar(Long grupo_id);

    List<Grupo> consultar(Long grupo_id);

    List<Grupo> consultarPorNombre(String nombreClase);

    List<Grupo> consultarTodos();

}
