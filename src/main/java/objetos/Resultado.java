/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.io.InputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.websocket.Decoder.Binary;

/**
 *
 * @author sergi
 */
public class Resultado implements Serializable{
    
    public static final String RESULTADO_DB_NAME="resultado";
    public static final String DB_CODIGO="codigo";
    public static final String DB_FECHA="fecha";
    public static final String DB_HORA="hora";
    public static final String DB_VERIFICADO="verificado";
    public static final String DB_DOCUMENTO="documento";
    public static final String DB_ORDEN_HECHA="orden_hecha";
    public static final String DB_PACIENTE_CODIGO="paciente_codigo";
    public static final String DB_MEDICO_CODIGO="medico_codigo";
    public static final String DB_EXAMEN_CODIGO="examen_codigo";
    public static final String DB_LABORATORISTA_CODIGO="laboratorista_codigo";
    
    private int codigo;
    private String fecha;
    private String hora;
    private boolean verificado;
    private InputStream docuemto;
    private InputStream ordeHecha;
    private int pacienteCodigo;
    private String medicoCodigo;
    private int examenCodigo;
    private String laboratoristaCodigo;
    
    private int tamañoOrden;
    private int tamañoInforme;
    
    //atributos para consultas
    private String nombreExamen;
    private String nombreLaboratorista;
    private String nombrePaciente;
    private String nombreMedico;
    
    public Resultado(){
        
    }

    public Resultado(int codigo, String fecha, String hora, boolean verificado, InputStream docuemto, InputStream ordeHecha, int pacienteCodigo, String medicoCodigo, int examenCodigo, String laboratoristaCodigo) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.verificado = verificado;
        this.docuemto = docuemto;
        this.ordeHecha = ordeHecha;
        this.pacienteCodigo = pacienteCodigo;
        this.medicoCodigo = medicoCodigo;
        this.examenCodigo = examenCodigo;
        this.laboratoristaCodigo = laboratoristaCodigo;
    }    

    public Resultado(String fecha, String hora, boolean verificado, InputStream docuemto, int pacienteCodigo, int examenCodigo) {
        this.fecha = fecha;
        this.hora = hora;
        this.verificado = verificado;
        this.docuemto = docuemto;
        this.pacienteCodigo = pacienteCodigo;
        this.examenCodigo = examenCodigo;
    }
    //es para la consulta de todos los examenes hechos por un usuario
    public Resultado(int codigo, String fecha, String hora, String nombreExamen) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.nombreExamen = nombreExamen;
    }
    
    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public String getNombreLaboratorista() {
        return nombreLaboratorista;
    }

    public void setNombreLaboratorista(String nombreLaboratorista) {
        this.nombreLaboratorista = nombreLaboratorista;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    
    public int getTamañoOrden() {
        return tamañoOrden;
    }

    public void setTamañoOrden(int tamañoOrden) {
        this.tamañoOrden = tamañoOrden;
    }

    public int getTamañoInforme() {
        return tamañoInforme;
    }

    public void setTamañoInforme(int tamañoInforme) {
        this.tamañoInforme = tamañoInforme;
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

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public InputStream getDocuemto() {
        return docuemto;
    }

    public void setDocuemto(InputStream docuemto) {
        this.docuemto = docuemto;
    }

    public InputStream getOrdeHecha() {
        return ordeHecha;
    }

    public void setOrdeHecha(InputStream ordeHecha) {
        this.ordeHecha = ordeHecha;
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

    public int getExamenCodigo() {
        return examenCodigo;
    }

    public void setExamenCodigo(int examenCodigo) {
        this.examenCodigo = examenCodigo;
    }

    public String getLaboratoristaCodigo() {
        return laboratoristaCodigo;
    }

    public void setLaboratoristaCodigo(String laboratoristaCodigo) {
        this.laboratoristaCodigo = laboratoristaCodigo;
    }
    
    
    

    
}
