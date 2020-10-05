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
import objetos.Cita;

/**
 *
 * @author sergi
 */
public class CitaModelo {
    
    private static String ADD_CITA = "INSERT INTO "+ Cita.CITA_DB_NAME+ " ( " +Cita.DB_CODIGO+","+Cita.DB_FECHA+","+Cita.DB_HORA+","+Cita.DB_MEDICO_CODIGO+","
            +Cita.DB_PACIENTE_CODIGO+") VALUES(?,?,?,?,?)";
    
    private Connection connection = ConnectionDB.getInstance();
    
    public void addCita(Cita cita) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(ADD_CITA);

        preSt.setInt(1, cita.getCodigo());
        preSt.setString(2, cita.getFecha());
        preSt.setString(3, cita.getHora());
        preSt.setString(4, cita.getMedicoCodigo()); 
        preSt.setInt(5, cita.getPacienteCodigo()); 
        
        preSt.executeUpdate();        
    }
}
