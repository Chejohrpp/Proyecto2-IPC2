/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.io.Serializable;

/**
 *
 * @author sergi
 */
public class Examen implements Serializable {
    
    public static final String EXAMEN_DB_NAME="examen";
    public static final String DB_CODIGO="codigo";
    public static final String DB_NOMBRE="nombre";
    public static final String DB_TIPO="tipo";
    public static final String DB_ORDEN="orden";
    public static final String DB_COSTO="costo";
    public static final String DB_DESCRIPCION="descripcion";
    
    private int codigo;
    private String nombre;
    private String tipo;
    private boolean orden;
    private double costo;
    private String descripcion;
    
    public Examen(){
        
    }

    public Examen(int codigo, String nombre, String tipo, boolean orden, double costo, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.orden = orden;
        this.costo = costo;
        this.descripcion = descripcion;
    }

    public Examen(String nombre, String tipo, boolean orden, double costo, String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.orden = orden;
        this.costo = costo;
        this.descripcion = descripcion;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isOrden() {
        return orden;
    }

    public void setOrden(boolean orden) {
        this.orden = orden;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
