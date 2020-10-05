/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author sergi
 */
public class Informe implements Serializable {
    public static final String INFORME_DB_NAME="informe";
    public static final String DB_CODIGO="codigo";
    public static final String DB_DESCRIPCION="descripcion";
    public static final String DB_HORA="hora";
    public static final String DB_FECHA="fecha";
    public static final String DB_COSTO="costo";
    public static final String DB_PACIENTE_CODIGO="paciente_codigo";
    public static final String DB_MEDICO_CODIGO="medico_codigo";
    
    private int coidigo;
    private String descripcion;
    private String hora;
    private String fecha;
    private double costo;
    private int pacienteCodigo;
    private String medicoCodigo;
    
    public Informe(){
        
   }
    //si no tiene costo colocamos 0
    public Informe(int coidigo, String descripcion, String hora, String fecha, double costo, int pacienteCodigo, String medicoCodigo) {
        this.coidigo = coidigo;
        this.descripcion = descripcion;
        this.hora = hora;
        this.fecha = fecha;
        this.costo = costo;
        this.pacienteCodigo = pacienteCodigo;
        this.medicoCodigo = medicoCodigo;
    }

    public Informe(String descripcion, String hora, String fecha, double costo, int pacienteCodigo, String medicoCodigo) {
        this.descripcion = descripcion;
        this.hora = hora;
        this.fecha = fecha;
        this.costo = costo;
        this.pacienteCodigo = pacienteCodigo;
        this.medicoCodigo = medicoCodigo;
    }
    

    public int getCoidigo() {
        return coidigo;
    }

    public void setCoidigo(int coidigo) {
        this.coidigo = coidigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getPacienteCodigo() {
        return pacienteCodigo;
    }

    public void setPacienteCodigo(int pacienteCodigo) {
        this.pacienteCodigo = pacienteCodigo;
    }

    public String getMedicoCodigo() {
        return medicoCodigo;
    }

    public void setMedicoCodigo(String medicoCodigo) {
        this.medicoCodigo = medicoCodigo;
    }
    
    
}
