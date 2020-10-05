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
import objetos.Admin;
import objetos.Medico;

/**
 *
 * @author sergi
 */
public class MedicoModelo {
    
    private static String ATRIBUTOS = Medico.DB_CODIGO+","+Medico.DB_NOMBRE+","+Medico.DB_COLEGIADO+","+Medico.DB_DPI+","
            +Medico.DB_TELEFONO+","+Medico.DB_EMAIL+","+Medico.DB_NAME_HORARIO_INICIO+","+Medico.DB_NAME_HORARIO_FINAL+","+Medico.DB_NAME_FECHA_EMPEZO;
    
    private static String ADD_MEDICO = "INSERT INTO " +Medico.MEDICO_DB_NAME+" ( " + ATRIBUTOS +","+ Medico.DB_PASSWORD+") VALUES(?,?,?,?,?,?,?,?,?,AES_ENCRYPT(?,?))";
    
    private static String MEDICO ="SELECT " +ATRIBUTOS+",cast(aes_decrypt("+ Medico.DB_PASSWORD +",?) as char) "+Medico.DB_PASSWORD+ " FROM " + Medico.MEDICO_DB_NAME;
    
    private static String BUSCAR_MEDICO = MEDICO +" WHERE " +Medico.DB_CODIGO+ " =? LIMIT 1";
    
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
    
    public Medico obtenerMedico(String codigo)throws SQLException{        
        PreparedStatement preSt = connection.prepareStatement(BUSCAR_MEDICO);
        
        preSt.setString(1, Admin.LLAVE);
        preSt.setString(2, codigo);
        
        ResultSet result = preSt.executeQuery();
        Medico medico = null;
        while(result.next()){
            medico = new Medico(
                    result.getString(Medico.DB_CODIGO),
                    result.getString(Medico.DB_NOMBRE),
                    result.getString(Medico.DB_COLEGIADO),
                    result.getString(Medico.DB_DPI),          
                    result.getString(Medico.DB_TELEFONO),          
                    result.getString(Medico.DB_EMAIL),            
                    result.getString(Medico.DB_NAME_HORARIO_INICIO),            
                    result.getString(Medico.DB_NAME_HORARIO_FINAL),            
                    result.getString(Medico.DB_NAME_FECHA_EMPEZO),           
                    result.getString(Medico.DB_PASSWORD)            
            );
        }
        return medico;
        
    }
    public Medico verificarLogin(String id,String pass)throws SQLException{
        Medico medico = obtenerMedico(id);
        if (medico!=null && pass.equals(medico.getPassword())) {
            return medico;
        }
        return null;       
    }
}
