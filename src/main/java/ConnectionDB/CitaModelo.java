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
import objetos.Cita;
import objetos.Medico;

/**
 *
 * @author sergi
 */
public class CitaModelo {
    
    private static String ADD_CITA = "INSERT INTO "+ Cita.CITA_DB_NAME+ " ( " +Cita.DB_CODIGO+","+Cita.DB_FECHA+","+Cita.DB_HORA+","+Cita.DB_MEDICO_CODIGO+","
            +Cita.DB_PACIENTE_CODIGO+") VALUES(?,?,?,?,?)";
    
    //consultas con mas de dos tablas
    
    private static String BUSCAR_CITAS_PACIENTE = "SELECT c."+Cita.DB_CODIGO+",c."+Cita.DB_FECHA+",c."+Cita.DB_HORA+",m."+Medico.DB_NOMBRE+" from " +Cita.CITA_DB_NAME+" c, " +Medico.MEDICO_DB_NAME+" m "
            + "WHERE c." +Cita.DB_PACIENTE_CODIGO+"=? AND c." +Cita.DB_MEDICO_CODIGO+"=m." +Medico.DB_CODIGO+" AND c." +Cita.DB_FECHA+">=NOW() ORDER BY c." +Cita.DB_FECHA+" DESC";
    
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
    
    public List<Cita> todasCitasPaciente(int codigo) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(BUSCAR_CITAS_PACIENTE);
        preSt.setInt(1, codigo);
        ResultSet result = preSt.executeQuery();
        List<Cita> citas = new LinkedList<>();
        while(result.next()){
            citas.add(new Cita( 
                    result.getInt(Cita.DB_CODIGO),
                    result.getString(Cita.DB_FECHA),
                    result.getString(Cita.DB_HORA),
                    result.getString(Medico.DB_NOMBRE)            
            ));
        }
        return citas;
        
    }
}
