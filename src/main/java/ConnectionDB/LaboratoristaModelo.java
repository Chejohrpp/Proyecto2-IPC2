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
import objetos.Laboratorista;

/**
 *
 * @author sergi
 */
public class LaboratoristaModelo {
    
    private static String ADD_LABORATORISTA="INSERT INTO "+ Laboratorista.LAB_DB_NAME +" ( " +Laboratorista.DB_CODIGO +","+Laboratorista.DB_NOMBRE +","
            +Laboratorista.DB_NUM_MINISTERIO +","+Laboratorista.DB_DPI +","+Laboratorista.DB_TELEFONO +","+Laboratorista.DB_EMAIL +","+Laboratorista.DB_FECHA_EMPEZO +","
            +Laboratorista.DB_EXAMEN +","+Laboratorista.DB_PASSWORD +") VALUES(?,?,?,?,?,?,?,?,AES_ENCRYPT(?,?))";
    
    private static Connection connection = ConnectionDB.getInstance();
    
    public void addLaboratorista(Laboratorista laboratorista) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(ADD_LABORATORISTA);

        preSt.setString(1, laboratorista.getCodigo());
        preSt.setString(2, laboratorista.getNombre());
        preSt.setString(3, laboratorista.getNumMinisterio());
        preSt.setString(4, laboratorista.getDpi());    
        preSt.setString(5, laboratorista.getTelefono());    
        preSt.setString(6, laboratorista.getEmail());    
        preSt.setString(7, laboratorista.getFechaEmpezo().toString());    
        preSt.setInt(8, laboratorista.getExamenCodigo());    
        preSt.setString(9, laboratorista.getPassword());    
        preSt.setString(10, Admin.LLAVE);
        preSt.executeUpdate();        
    }
    
}
