/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Grupo;
import interfaces.IConexionBD;
import interfaces.IGruposDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GruposDAO implements IGruposDAO{

    IConexionBD conexion;
    Connection con;
    
    public GruposDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public boolean agregar(Grupo grupo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean editar(Grupo grupo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(Grupo grupo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Grupo> consultarGrupos() {
        List<Grupo> listaGrupos = new ArrayList<>();
        ResultSet result = null;
        String SQL = "SELECT * FROM grupos";
        try {
            con = conexion.obtenerConexion();
            PreparedStatement st = con.prepareStatement(SQL);
            result = st.executeQuery();
            while (result.next()) {
                Long id_grupo = result.getLong("id");
                String nombre = result.getString("nombreClase");
                String horaInicio = result.getString("horaInicio");
                String horaFin = result.getString("horaFin");
                listaGrupos.add(new Grupo(id_grupo, nombre, horaInicio, horaFin));
            }
            return listaGrupos;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
}
