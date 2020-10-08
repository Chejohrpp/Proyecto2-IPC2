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
import java.util.LinkedList;
import java.util.List;
import objetos.Admin;
import objetos.Examen;
import objetos.Informe;
import objetos.Medico;
import objetos.Paciente;
import objetos.Resultado;

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
    
    private static String ADD_PACIENTE = "INSERT INTO " + Paciente.PACIENTE_DB_NAME+" ( " +Paciente.DB_CODIGO+","+ATRIBUTOS_PACIENTE+"," +Paciente.DB_PASSWORD+ " ) VALUES(?,?,?,?,?,?,?,?,?,AES_ENCRYPT(?,?) )";
    
    private static String MOD_PACIENTE = "UPDATE " +Paciente.PACIENTE_DB_NAME +" SET "+Paciente.DB_NOMBRE +"=?,"
            +Paciente.DB_GENERO +"=?, "+Paciente.DB_FECHA_NACIMIENTO +"=?,"+Paciente.DB_DPI +"=?, "+Paciente.DB_TELEFONO +"=?,"
            +Paciente.DB_PESO +"=?, "+Paciente.DB_SANGRE +"=? ,"+Paciente.DB_EMAIL +"=?, "+Paciente.DB_PASSWORD +"=AES_ENCRYPT(?,?) WHERE "+Paciente.DB_CODIGO+"=?";
    
    //QUERYS usando mas de una tabla
    
    private static String INFORMES = "SELECT i."+Informe.DB_HORA+",i."+Informe.DB_FECHA+",i."+Informe.DB_CODIGO+",m."+Medico.DB_NOMBRE+"  FROM "+Informe.INFORME_DB_NAME+" i, "
            +Medico.MEDICO_DB_NAME+"  m WHERE i."+Informe.DB_PACIENTE_CODIGO+"=? AND m."+Medico.DB_CODIGO+"=i."+Informe.DB_MEDICO_CODIGO+" ORDER BY i."+Informe.DB_FECHA+" DESC";
    
    private static String INFORMES_LIMITE5 = INFORMES + " LIMIT 5";
    
    private static String RESULTADOS = "SELECT r."+Resultado.DB_FECHA+",r."+Resultado.DB_HORA+",r."+Resultado.DB_CODIGO+",e."+Examen.DB_NOMBRE+" FROM "+Resultado.RESULTADO_DB_NAME+"  r, "+Examen.EXAMEN_DB_NAME+"  e "
            + "WHERE r."+Resultado.DB_PACIENTE_CODIGO+"=? AND r."+Resultado.DB_EXAMEN_CODIGO+" =e."+Examen.DB_CODIGO+"  AND r."+Resultado.DB_VERIFICADO+"=1 ORDER BY r."+Resultado.DB_FECHA+"  DESC";
    
    private static String RESULTADOS_LIMIT5 = RESULTADOS + " LIMIT 5";
    
    private static Connection connection = ConnectionDB.getInstance();
    
    //sirve para agregar un paciente a la DB, y la misma base de datos le asigna un codigo
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
    //obtenemos un paciente
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
    //verificamos si los datos del login coinciden con algun registro 
    public Paciente verificarLogin(int codigo, String pass) throws SQLException {
        Paciente paciente = obtenerPaciente(codigo);
        if (paciente != null && paciente.getPassword().equals(pass)) {
            return paciente;
        }
        return null;        
    }
    //agregamos un paciente a la DB con codigo
    public void addPaciente(Paciente paciente) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(ADD_PACIENTE);
        
        preSt.setInt(1, paciente.getCodigo());
        preSt.setString(2, paciente.getNombre());
        preSt.setString(3, paciente.getGenero());
        preSt.setString(4, paciente.getFechaNacimiento());
        preSt.setString(5, paciente.getDpi());
        preSt.setString(6, paciente.getTelefono());
        preSt.setInt(7, paciente.getPeso());
        preSt.setString(8, paciente.getSangre());
        preSt.setString(9, paciente.getEmail());        
        preSt.setString(10, paciente.getPassword());
        preSt.setString(11, Admin.LLAVE);

        preSt.executeUpdate();        
     
    }
    //traemos todos los informes de un paciente
    public List<Informe> todosInformes(int codigo) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(INFORMES);
        preSt.setInt(1, codigo);
        List<Informe> informes = new LinkedList<>();
         ResultSet result = preSt.executeQuery();
        while(result.next()){
            informes.add(new Informe(
                    result.getInt(Informe.DB_CODIGO),
                    result.getString(Informe.DB_HORA),
                    result.getString(Informe.DB_FECHA),
                    result.getString(Medico.DB_NOMBRE)           
            ));
        }
        
        return informes;
        
    }
    //treaemos el reporte de los 5 ultimos consultas de un paciente
    public List<Informe> todosInformesLimite5(int codigo) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(INFORMES_LIMITE5);
        preSt.setInt(1, codigo);
        List<Informe> informes = new LinkedList<>();
         ResultSet result = preSt.executeQuery();
        while(result.next()){
            informes.add(new Informe(
                    result.getInt(Informe.DB_CODIGO),
                    result.getString(Informe.DB_HORA),
                    result.getString(Informe.DB_FECHA),
                    result.getString(Medico.DB_NOMBRE)           
            ));
        }
        
        return informes;
        
    }
    //treamos todo los examenes de un paciente
    public List<Resultado> todosExamenes(int codigo) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(RESULTADOS);
        preSt.setInt(1, codigo);
        List<Resultado> resultados = new LinkedList<>();
         ResultSet result = preSt.executeQuery();
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
    //lo usamos para el reporte de los ultimos 5 examenes de un paciente
    public List<Resultado> todosExamenesLimit5(int codigo) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(RESULTADOS_LIMIT5);
        preSt.setInt(1, codigo);
        List<Resultado> resultados = new LinkedList<>();
         ResultSet result = preSt.executeQuery();
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
    //es para modificar los datos de algun paciente
    public void modPaciente(Paciente paciente) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(MOD_PACIENTE);
        
        
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
        preSt.setInt(11, paciente.getCodigo());

        preSt.executeUpdate();
    }
}
