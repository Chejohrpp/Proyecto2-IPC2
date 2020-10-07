/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionDB;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import objetos.Admin;
import objetos.Examen;
import objetos.Resultado;

/**
 *
 * @author sergi
 */
public class ResultadoModelo {
    
    private static String ADD_RESULTADO = "INSERT INTO "+Resultado.RESULTADO_DB_NAME+" ( " +Resultado.DB_CODIGO+","+Resultado.DB_FECHA+","+Resultado.DB_HORA+","
            +Resultado.DB_VERIFICADO+","+Resultado.DB_DOCUMENTO+","+Resultado.DB_ORDEN_HECHA+","+Resultado.DB_PACIENTE_CODIGO+","+Resultado.DB_MEDICO_CODIGO+","
            +Resultado.DB_EXAMEN_CODIGO+","+Resultado.DB_LABORATORISTA_CODIGO+") VALUES(?,?,?,?,?,?,?,?,?,?)";
    
    
    //consultas con más de dos tablas
    private static String BUSCAR_EXAMENES_PACIENTE = "SELECT r."+Resultado.DB_FECHA+",r."+Resultado.DB_HORA+",r." +Resultado.DB_CODIGO+",e."+Examen.DB_NOMBRE+" FROM " +Resultado.RESULTADO_DB_NAME+" r , " +Examen.EXAMEN_DB_NAME+" e"
            + " WHERE r." +Resultado.DB_PACIENTE_CODIGO+"=? AND r." +Resultado.DB_EXAMEN_CODIGO+"=e." +Examen.DB_CODIGO+" AND r." +Resultado.DB_FECHA+">=NOW() ORDER BY r." +Resultado.DB_FECHA+" DESC";
    
    
    private static Connection connection = ConnectionDB.getInstance();
    
    public void addResultado(Resultado resultado) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(ADD_RESULTADO);
        
        preSt.setInt(1, resultado.getCodigo());
        preSt.setString(2, resultado.getFecha());
        preSt.setString(3, resultado.getHora());
        preSt.setBoolean(4, resultado.isVerificado());
        preSt.setBinaryStream(5, resultado.getDocuemto());
        preSt.setBinaryStream(6, resultado.getOrdeHecha());
        preSt.setInt(7, resultado.getPacienteCodigo());
        preSt.setString(8, resultado.getMedicoCodigo());
        preSt.setInt(9, resultado.getExamenCodigo());
        preSt.setString(10, resultado.getLaboratoristaCodigo());
        preSt.executeUpdate();        
    }
    
    public List<Resultado> todasCitasPaciente(int codigoPaciente)  throws SQLException {
        PreparedStatement preSt = connection.prepareStatement(BUSCAR_EXAMENES_PACIENTE);
        preSt.setInt(1, codigoPaciente);
        ResultSet result = preSt.executeQuery();
        List<Resultado> resultados = new LinkedList<>();
        while(result.next()){
            resultados.add(new Resultado(
                    result.getInt(Resultado.DB_CODIGO),
                    result.getString(Resultado.DB_FECHA),
                    result.getString(Resultado.DB_HORA),
                    result.getString(Examen.DB_NOMBRE)
            ));
        }
        return resultados;       
        
    }
    
}
