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

/**
 *
 * @author sergi
 */
public class AdminModelo {
    
    private static String ADD_ADMIN ="INSERT INTO " + Admin.ADMIN_DB_NAME+" ( "+Admin.DB_CODIGO+","+Admin.DB_NOMBRE+","+Admin.DB_DPI+","+Admin.DB_PASSWORD+") VALUES(?,?,?,AES_ENCRYPT(?,?))";
    
    private static String CANTIDAD_ADMINS = "SELECT COUNT(*) cantidad FROM " +Admin.ADMIN_DB_NAME+ " LIMIT 1";
    
    private static String ADMIN = "SELECT " + Admin.DB_CODIGO+","+Admin.DB_NOMBRE+","+Admin.DB_DPI +",cast(aes_decrypt("+ Admin.DB_PASSWORD +",?) as char) "+Admin.DB_PASSWORD+
            " FROM " + Admin.ADMIN_DB_NAME;
    
    private static String BUSCAR_ADMIN = ADMIN + " WHERE "+Admin.DB_CODIGO+" = ? LIMIT 1";
    
    private static Connection connection = ConnectionDB.getInstance();

    public AdminModelo() {
    }
    
    
    public void addAdmin(Admin admin) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(ADD_ADMIN);

        preSt.setString(1, admin.getCodigo());
        preSt.setString(2, admin.getNombre());
        preSt.setString(3, admin.getDpi());
        preSt.setString(4, admin.getPassword());        
        preSt.setString(5, Admin.LLAVE);
        preSt.executeUpdate();        
    }
    
    public static int cantAdmins() throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(CANTIDAD_ADMINS);
        
        ResultSet result = preSt.executeQuery();
          int cantAdmins = 0;
        if (result.next()) {
            cantAdmins = result.getInt(1);
        }        
        return cantAdmins;
    }
    public Admin obtenerAdmin(String codigo)throws SQLException{        
        PreparedStatement preSt = connection.prepareStatement(BUSCAR_ADMIN);
        
        preSt.setString(1, Admin.LLAVE);
        preSt.setString(2, codigo);
        
        ResultSet result = preSt.executeQuery();
        Admin admin = null;
        while(result.next()){
            admin = new Admin(
                    result.getString(Admin.DB_CODIGO),
                    result.getString(Admin.DB_NOMBRE),
                    result.getString(Admin.DB_DPI),
                    result.getString(Admin.DB_PASSWORD)            
            );
        }
        return admin;
        
    }
    public Admin verificarLogin(String id,String pass)throws SQLException{
        Admin admin = obtenerAdmin(id);
        if (admin!=null && pass.equals(admin.getPassword())) {
            return admin;
        }
        return null;       
    }
}
