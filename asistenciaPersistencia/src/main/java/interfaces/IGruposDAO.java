/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Grupo;
import java.util.List;

public interface IGruposDAO {
    
    public boolean agregar(Grupo grupo);
    public boolean editar(Grupo grupo);
    public boolean eliminar(Grupo grupo);
    public List<Grupo> consultarGrupos();
}
