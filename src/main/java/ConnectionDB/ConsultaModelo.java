/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import objetos.Admin;
import objetos.Especialidad;

/**
 *
 * @author sergi
 */
public class ConsultaModelo {
    
    private static String ADD_CONSULTA = "INSERT INTO "+ Especialidad.ESPECIALIDAD_DB_NAME + " ( "+ Especialidad.DB_NOMBRE+","+Especialidad.DB_PRECIO+") VALUES(?,?)";
    
    private static String BUSCAR_ID_ESPECIALIDAD = "SELECT " + Especialidad.DB_ID +" FROM " + Especialidad.ESPECIALIDAD_DB_NAME + " WHERE " +Especialidad.DB_NOMBRE +" = ? LIMIT 1";
    private Connection connection = ConnectionDB.getInstance();
    
    public void addConsulta(Especialidad especialidad) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(ADD_CONSULTA);

        preSt.setString(1, especialidad.getNombre());
        preSt.setDouble(2, especialidad.getPrecio());
        
        preSt.executeUpdate();        
    }
    
    public int buscarIdEspecialidad(String nombre) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(BUSCAR_ID_ESPECIALIDAD);
        preSt.setString(1, nombre);
        ResultSet result = preSt.executeQuery();
        int ID = 0;
        if (result.next()) {
            ID= result.getInt(1);
        }
        return ID;
        
    }
}
