/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author sergi
 */
public class Cita {
    
    public static final String CITA_DB_NAME="cita";
    public static final String DB_CODIGO="codigo";
    public static final String DB_FECHA="fecha";
    public static final String DB_HORA="hora";
    public static final String DB_PACIENTE_CODIGO="paciente_codigo";
    public static final String DB_MEDICO_CODIGO="medico_codigo";
    
    private int codigo;
    private LocalDate fecha;
    private LocalTime hora;
    private int pacienteCodigo;
    private String medicoCodigo;
    
    public Cita(){
        
    }

    public Cita(int codigo, LocalDate fecha, LocalTime hora, int pacienteCodigo, String medicoCodigo) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.pacienteCodigo = pacienteCodigo;
        this.medicoCodigo = medicoCodigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
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
