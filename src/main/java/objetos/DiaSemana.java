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
public class DiaSemana {
    
    public static final String DIA_SEMANA_DB_NOMBRE="dia_semana";
    public static final String _DB_ID="id";
    public static final String DB_NOMBRE="nombre";
    
    private int id;
    private String nombre;
    
    public DiaSemana(){
        
    }

    public DiaSemana(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
    

}
