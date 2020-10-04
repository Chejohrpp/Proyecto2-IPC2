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
public class Laboratorista implements Serializable {
    
    public static final String LAB_DB_NAME="laboratorista";
    public static final String DB_CODIGO="codigo";
    public static final String DB_NOMBRE="nombre";
    public static final String DB_NUM_MINISTERIO="num_ministerio";
    public static final String DB_DPI="dpi";
    public static final String DB_TELEFONO="telefono";
    public static final String DB_EMAIL="email";
    public static final String DB_FECHA_EMPEZO="fecha_empezo";
    public static final String DB_EXAMEN="examen";
    public static final String DB_PASSWORD="password";
    
    
    private String codigo;
    private String nombre;
    private String numMinisterio;
    private String dpi;
    private String telefono;
    private String email;
    private LocalDate fechaEmpezo;
    private int examenCodigo;
    private String password;
    
    public Laboratorista(){
        
    }

    public Laboratorista(String codigo, String nombre, String numMinisterio, String dpi, String telefono, String email, LocalDate fechaEmpezo, int examenCodigo, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numMinisterio = numMinisterio;
        this.dpi = dpi;
        this.telefono = telefono;
        this.email = email;
        this.fechaEmpezo = fechaEmpezo;
        this.examenCodigo = examenCodigo;
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

    public String getNumMinisterio() {
        return numMinisterio;
    }

    public void setNumMinisterio(String numMinisterio) {
        this.numMinisterio = numMinisterio;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaEmpezo() {
        return fechaEmpezo;
    }

    public void setFechaEmpezo(LocalDate fechaEmpezo) {
        this.fechaEmpezo = fechaEmpezo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getExamenCodigo() {
        return examenCodigo;
    }

    public void setExamenCodigo(int examenCodigo) {
        this.examenCodigo = examenCodigo;
    }
    
    
}
