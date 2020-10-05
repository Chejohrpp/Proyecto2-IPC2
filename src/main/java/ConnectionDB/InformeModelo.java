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
import objetos.Informe;

/**
 *
 * @author sergi
 */
public class InformeModelo {
    
    private static String ADD_INFORME = "INSERT INTO " + Informe.INFORME_DB_NAME+ " ( " + Informe.DB_CODIGO+","+ Informe.DB_DESCRIPCION+","+ Informe.DB_HORA+","+ Informe.DB_FECHA+","
            + Informe.DB_COSTO+","+ Informe.DB_PACIENTE_CODIGO+","+ Informe.DB_MEDICO_CODIGO+") VALUES(?,?,?,?,?,?,?)";
    private Connection connection = ConnectionDB.getInstance();
    
    public void addInforme(Informe informe) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(ADD_INFORME);

        preSt.setInt(1, informe.getCoidigo());
        preSt.setString(2, informe.getDescripcion());
        preSt.setString(3, informe.getHora());
        preSt.setString(4, informe.getFecha());        
        preSt.setDouble(5, informe.getCosto());        
        preSt.setInt(6, informe.getPacienteCodigo());        
        preSt.setString(7, informe.getMedicoCodigo());
        
        preSt.executeUpdate();        
    }
}
