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
public class Especialidad implements Serializable {
    
    public static final String ESPECIALIDAD_DB_NAME="especialidad";
    public static final String DB_ID="id";
    public static final String DB_NOMBRE="nombre";
    public static final String DB_PRECIO="precio";
    
    private int id;
    private String nombre;
    private double precio;
    
    public Especialidad(){
        
    }

    public Especialidad(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Especialidad(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
