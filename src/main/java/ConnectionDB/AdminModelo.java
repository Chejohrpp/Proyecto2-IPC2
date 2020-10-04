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
    
    private static Connection connection = ConnectionDB.getInstance();
    
    public void addAdmin(Admin admin) throws SQLException{
        PreparedStatement preSt = connection.prepareStatement(ADD_ADMIN);

        preSt.setString(1, admin.getCodigo());
        preSt.setString(2, admin.getNombre());
        preSt.setString(3, admin.getDpi());
        preSt.setString(4, admin.getPassword());        
        preSt.setString(5, Admin.LLAVE);
        preSt.executeUpdate();        
    }
}
