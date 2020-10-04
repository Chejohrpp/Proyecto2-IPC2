/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionDB;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import objetos.Admin;
import objetos.Resultado;

/**
 *
 * @author sergi
 */
public class ResultadoModelo {
    
    private static String ADD_RESULTADO = "INSERT INTO "+Resultado.RESULTADO_DB_NAME+" ( " +Resultado.DB_CODIGO+","+Resultado.DB_FECHA+","+Resultado.DB_HORA+","
            +Resultado.DB_VERIFICADO+","+Resultado.DB_DOCUMENTO+","+Resultado.DB_ORDEN_HECHA+","+Resultado.DB_PACIENTE_CODIGO+","+Resultado.DB_MEDICO_CODIGO+","
            +Resultado.DB_EXAMEN_CODIGO+","+Resultado.DB_LABORATORISTA_CODIGO+") VALUES(?,?,?,?,?,?,?,?,?,?)";
    
    private static Connection connection = ConnectionDB.getInstance();
    
    public void addResultado(Resultado resultado) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(ADD_RESULTADO);
        
        preSt.setInt(1, resultado.getCodigo());
        preSt.setString(2, resultado.getFecha().toString());
        preSt.setString(3, resultado.getHora().toString());
        preSt.setBoolean(4, resultado.isVerificado());
        preSt.setBinaryStream(5, resultado.getDocuemto());
        preSt.setBinaryStream(6, resultado.getOrdeHecha());
        preSt.setInt(7, resultado.getPacienteCodigo());
        preSt.setString(8, resultado.getMedicoCodigo());
        preSt.setInt(9, resultado.getExamenCodigo());
        preSt.setString(10, resultado.getLaboratoristaCodigo());
        preSt.executeUpdate();        
    }
    
}
