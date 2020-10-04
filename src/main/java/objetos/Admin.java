/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author sergi
 */
public class Admin {
    
    public static final String ADMIN_DB_NAME="admin";
    public static final String DB_CODIGO="codigo";
    public static final String DB_NOMBRE="nombre";
    public static final String DB_DPI="dpi";
    public static final String DB_PASSWORD="contraseña";
    public static final String LLAVE="flipRefrigerador";
    
    private String codigo;
    private String nombre;
    private String dpi;
    private String password;
    
    public Admin(){
        
    }

    public Admin(String codigo, String nombre, String dpi, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.dpi = dpi;
        this.password = password;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
    
    
}
