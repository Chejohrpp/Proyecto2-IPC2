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
import java.sql.Statement;
import objetos.Admin;
import objetos.Paciente;

/**
 *
 * @author sergi
 */
public class PacienteModelo {
    
    private static String ATRIBUTOS_PACIENTE =Paciente.DB_NOMBRE+","+Paciente.DB_GENERO+","+Paciente.DB_FECHA_NACIMIENTO+","+Paciente.DB_DPI+","+Paciente.DB_TELEFONO+","
            +Paciente.DB_PESO+","+Paciente.DB_SANGRE+","+Paciente.DB_EMAIL;
        
    private static String ADD_PACIENTE_SIN_CODIGO = "INSERT INTO "+ Paciente.PACIENTE_DB_NAME +"("+ ATRIBUTOS_PACIENTE +","+Paciente.DB_PASSWORD+ ") VALUES(?,?,?,?,?,?,?,?,AES_ENCRYPT(?,?) )";
    
    
    private static String PACIENTES = "SELECT "+Paciente.DB_CODIGO+","+ ATRIBUTOS_PACIENTE +",cast(aes_decrypt("+Paciente.DB_PASSWORD +",?) as char) "+Paciente.DB_PASSWORD+
            " FROM " + Paciente.PACIENTE_DB_NAME;
    private static String BUSCAR_PACIENTE = PACIENTES + " WHERE "+Paciente.DB_CODIGO+" = ? LIMIT 1" ;
    
    private static Connection connection = ConnectionDB.getInstance();
    
    
    public long addPacienteSinCodigo(Paciente paciente) throws SQLException{
         PreparedStatement preSt = connection.prepareStatement(ADD_PACIENTE_SIN_CODIGO, Statement.RETURN_GENERATED_KEYS);

        preSt.setString(1, paciente.getNombre());
        preSt.setString(2, paciente.getGenero());
        preSt.setString(3, paciente.getFechaNacimiento());
        preSt.setString(4, paciente.getDpi());
        preSt.setString(5, paciente.getTelefono());
        preSt.setInt(6, paciente.getPeso());
        preSt.setString(7, paciente.getSangre());
        preSt.setString(8, paciente.getEmail());        
        preSt.setString(9, paciente.getPassword());
        preSt.setString(10, Admin.LLAVE);

        preSt.executeUpdate();

        ResultSet result = preSt.getGeneratedKeys();
        if (result.first()) {
            return result.getLong(1);
        }
        return -1;
     }
    
    public Paciente obtenerPaciente(int codigo) throws SQLException {
        PreparedStatement preSt = connection.prepareStatement(BUSCAR_PACIENTE);
        preSt.setString(1, Admin.LLAVE);
        preSt.setInt(2, codigo);        
        ResultSet result = preSt.executeQuery();
        Paciente paciente = null;
        while(result.next()){
            paciente = new Paciente(
                    result.getInt(Paciente.DB_CODIGO),
                    result.getString(Paciente.DB_NOMBRE),
                    result.getString(Paciente.DB_GENERO),
                    result.getString(Paciente.DB_FECHA_NACIMIENTO),
                    result.getString(Paciente.DB_DPI),
                    result.getString(Paciente.DB_TELEFONO),
                    result.getInt(Paciente.DB_PESO),
                    result.getString(Paciente.DB_SANGRE),
                    result.getString(Paciente.DB_EMAIL),
                    result.getString(Paciente.DB_PASSWORD)            
            );
        }
        return paciente;
    }
    
    public Paciente verificarLogin(int codigo, String pass) throws SQLException {
        Paciente paciente = obtenerPaciente(codigo);
        if (paciente != null && paciente.getPassword().equals(pass)) {
            return paciente;
        }
        return null;        
    }
    
}
