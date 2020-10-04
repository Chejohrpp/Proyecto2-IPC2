/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author sergi
 */
public class Paciente implements Serializable{
    
    public static final String PACIENTE_DB_NAME="paciente";
    public static final String DB_CODIGO="codigo";
    public static final String DB_NOMBRE="nombre";
    public static final String DB_GENERO="genero";
    public static final String DB_FECHA_NACIMIENTO="fecha_nacimiento";
    public static final String DB_DPI="dpi";
    public static final String DB_TELEFONO="telefono";
    public static final String DB_PESO="peso";
    public static final String DB_SANGRE="sangre";
    public static final String DB_EMAIL="email";
    public static final String DB_PASSWORD="contraseña";
    
    private int codigo;
    private String nombre;
    private String genero;
    private String fechaNacimiento;
    private String dpi;
    private String telefono;
    private int peso;
    private String sangre;
    private String email;
    private String password;
    
    public Paciente(){
        
    }

    public Paciente(int codigo, String nombre, String genero, String fechaNacimiento, String dpi, String telefono, int peso, String sangre, String email, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.dpi = dpi;
        this.telefono = telefono;
        this.peso = peso;
        this.sangre = sangre;
        this.email = email;
        this.password = password;
    }

    public Paciente(String nombre, String genero, String fechaNacimiento, String dpi, String telefono, int peso, String sangre, String email, String password) {
        this.nombre = nombre;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.dpi = dpi;
        this.telefono = telefono;
        this.peso = peso;
        this.sangre = sangre;
        this.email = email;
        this.password = password;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getSangre() {
        return sangre;
    }

    public void setSangre(String sangre) {
        this.sangre = sangre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
