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
import java.util.LinkedList;
import java.util.List;
import objetos.Admin;
import objetos.Examen;

/**
 *
 * @author sergi
 */
public class ExamenModelo {
    
    private static String ATRIBUTOS = Examen.DB_CODIGO +","+ Examen.DB_NOMBRE +","+ Examen.DB_TIPO +","
            + Examen.DB_ORDEN +","+ Examen.DB_COSTO +","+ Examen.DB_DESCRIPCION;
    
    private static String ADD_EXAMEN =  "INSERT INTO "+ Examen.EXAMEN_DB_NAME+" ( "+ ATRIBUTOS +") VALUES(?,?,?,?,?,?)";
    
    private static String BUSCAR_ID_EXAMEN= "SELECT " + Examen.DB_CODIGO +" FROM " + Examen.EXAMEN_DB_NAME + " WHERE " +Examen.DB_NOMBRE +" = ? LIMIT 1";
    
    private static String EXAMEN = "SELECT " +ATRIBUTOS+ " FROM " +Examen.EXAMEN_DB_NAME;
    
    private static String BUSCAR_EXAMENES_NOMBRE = EXAMEN + " WHERE " +Examen.DB_NOMBRE +" LIKE ? ";
            
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
    
    public int buscarIdExamen(String nombre) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(BUSCAR_ID_EXAMEN);
        preSt.setString(1, nombre);
        ResultSet result = preSt.executeQuery();
        int ID = 0;
        if (result.next()) {
            ID= result.getInt(1);
        }
        return ID;
        
    }
    private void llenarListas(ResultSet result, List<Examen> examenes) throws SQLException{
        
        while(result.next()){
            examenes.add(new Examen(
                    result.getInt(Examen.DB_CODIGO),
                    result.getString(Examen.DB_NOMBRE),
                    result.getString(Examen.DB_TIPO),
                    result.getBoolean(Examen.DB_ORDEN),
                    result.getDouble(Examen.DB_COSTO),
                    result.getString(Examen.DB_DESCRIPCION)    
            
            ));
            
        }
    }
    
    public List<Examen> todosExamenes() throws SQLException {
        PreparedStatement preSt = connection.prepareStatement(EXAMEN);        
        ResultSet result = preSt.executeQuery();        
        List<Examen> examenes = new LinkedList<>();        
        llenarListas(result,examenes);        
        
        return examenes;    
    }
    
    public List<Examen> todosExamenesNombre(String nombre) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(BUSCAR_EXAMENES_NOMBRE);   
        preSt.setString(1, "%"+nombre+"%");
        ResultSet result = preSt.executeQuery();        
        List<Examen> examenes = new LinkedList<>();
        llenarListas(result,examenes);         
        return examenes; 
    }
    
}
