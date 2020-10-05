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
import objetos.Medico;

/**
 *
 * @author sergi
 */
public class MedicoModelo {
     
    private static String ADD_MEDICO = "INSERT INTO " +Medico.MEDICO_DB_NAME+" ( " +Medico.DB_CODIGO+","+Medico.DB_NOMBRE+","+Medico.DB_COLEGIADO+","+Medico.DB_DPI+","
            +Medico.DB_TELEFONO+","+Medico.DB_EMAIL+","+Medico.DB_NAME_HORARIO_INICIO+","+Medico.DB_NAME_HORARIO_FINAL+","+Medico.DB_NAME_FECHA_EMPEZO+","
            +Medico.DB_PASSWORD+") VALUES(?,?,?,?,?,?,?,?,?,AES_ENCRYPT(?,?))";
    private static Connection connection = ConnectionDB.getInstance();
    
    public void addMedico(Medico medico) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(ADD_MEDICO);

        preSt.setString(1, medico.getCodigo());
        preSt.setString(2, medico.getNombre());
        preSt.setString(3, medico.getColegiado());
        preSt.setString(4, medico.getDpi());
        preSt.setString(5, medico.getTelefono());        
        preSt.setString(6, medico.getEmail());        
        preSt.setString(7, medico.getHorarioInicio());        
        preSt.setString(8, medico.getHorarioFinal());        
        preSt.setString(9, medico.getFechaEmpezo());        
        preSt.setString(10, medico.getPassword());        
        preSt.setString(11, Admin.LLAVE);
        preSt.executeUpdate();        
    }
}
