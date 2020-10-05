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
import objetos.DiaLab;

/**
 *
 * @author sergi
 */
public class DiaLabModelo {
    
    private static String ADD_DIA_LAB = "INSERT INTO "+DiaLab.DIA_LAB_DB_NAME+" ( " +DiaLab.DB_DIA_SEMANA+","+DiaLab.DB_LABORATORISTA_CODIGO+") VALUES (?,?)";
    
    private static Connection connection = ConnectionDB.getInstance();
    
    public void addDiaLab(DiaLab diaLab) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(ADD_DIA_LAB);

        preSt.setString(1, diaLab.getDiaSemana());
        preSt.setString(2, diaLab.getLaboratoristaCodigo());
        preSt.executeUpdate();        
    }
}
