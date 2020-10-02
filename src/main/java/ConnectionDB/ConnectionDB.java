/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sergi
 */
public class ConnectionDB {
    private Connection connection;
    
    public ConnectionDB(){
        String url = "jdbc:mysql://localhost:3306/mysql";
        String user = "user";
        String password = "user";
        try{
           connection = DriverManager.getConnection(url, user, password);     
            System.out.println("se conceto");
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public Connection getConnection(){
        return connection;
    }
    public void closeConnection() throws SQLException{
     connection.close();           
    }
    public String verificar(){
        if (connection != null) {
                return ("Conexion Establecida....");
            }
        return ("no se conecto");
    }
}
