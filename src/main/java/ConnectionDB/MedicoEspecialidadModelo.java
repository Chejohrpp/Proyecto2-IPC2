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
import objetos.MedicoEspecialidad;

/**
 *
 * @author sergi
 */
public class MedicoEspecialidadModelo {
    
    private static String ADD_MEDICO_ESPECIALIDAD = "INSERT INTO " + MedicoEspecialidad.MEDICO_ESPECIALIDAD_DB_NAME + " ( " +MedicoEspecialidad.DB_ESPECIALIDAD_ID+","
            +MedicoEspecialidad.DB_MEDICO_CODIGO+" ) VALUES(?,?)";
    
    
    
    private static Connection connection =  ConnectionDB.getInstance();
    
    public void addMedicoEspecialidad(MedicoEspecialidad medicoEspecialidad) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(ADD_MEDICO_ESPECIALIDAD);

        preSt.setInt(1, medicoEspecialidad.getEspecialidadId());
        preSt.setString(2, medicoEspecialidad.getMedicoCodigo());
        preSt.executeUpdate();        
    }
    
    
    
}
