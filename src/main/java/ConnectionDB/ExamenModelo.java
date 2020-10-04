/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import objetos.Admin;
import objetos.Examen;

/**
 *
 * @author sergi
 */
public class ExamenModelo {
    
    private static String ADD_EXAMEN =  "INSERT INTO "+ Examen.EXAMEN_DB_NAME+" ( "+ Examen.DB_CODIGO +","+ Examen.DB_NOMBRE +","+ Examen.DB_TIPO +","
            + Examen.DB_ORDEN +","+ Examen.DB_COSTO +","+ Examen.DB_DESCRIPCION +") VALUES(?,?,?,?,?,?)";
    private Connection connection = ConnectionDB.getInstance();
 
    public void addExamen(Examen examen) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(ADD_EXAMEN);

        preSt.setInt(1, examen.getCodigo());
        preSt.setString(2, examen.getNombre());
        preSt.setString(3, examen.getTipo());
        preSt.setBoolean(4, examen.isOrden());
        preSt.setDouble(5, examen.getCosto());
        preSt.setString(6, examen.getDescripcion());        
        preSt.executeUpdate();        
    }
}
