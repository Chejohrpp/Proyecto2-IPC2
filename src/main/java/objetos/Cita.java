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
public class Cita implements Serializable {
    
    public static final String CITA_DB_NAME="cita";
    public static final String DB_CODIGO="codigo";
    public static final String DB_FECHA="fecha";
    public static final String DB_HORA="hora";
    public static final String DB_PACIENTE_CODIGO="paciente_codigo";
    public static final String DB_MEDICO_CODIGO="medico_codigo";
    
    private int codigo;
    private String fecha;
    private String hora;
    private int pacienteCodigo;
    private String medicoCodigo;
    
    //atributos para consultas
    private String nombreMedico;
    private String nombrePaciente;
    
    public Cita(){
        
    }

    public Cita(int codigo, String fecha, String hora, int pacienteCodigo, String medicoCodigo) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.pacienteCodigo = pacienteCodigo;
        this.medicoCodigo = medicoCodigo;
    }

    public Cita(String fecha, String hora, int pacienteCodigo, String medicoCodigo) {
        this.fecha = fecha;
        this.hora = hora;
        this.pacienteCodigo = pacienteCodigo;
        this.medicoCodigo = medicoCodigo;
    }

    public Cita(int codigo, String fecha, String hora, String nombreMedico) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.nombreMedico = nombreMedico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
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
