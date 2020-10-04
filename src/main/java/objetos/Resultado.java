/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.websocket.Decoder.Binary;

/**
 *
 * @author sergi
 */
public class Resultado {
    
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
    private LocalDate fecha;
    private LocalTime hora;
    private boolean verificado;
    private Binary docuemto;
    private Binary ordeHecha;
    private int pacienteCodigo;
    private String medicoCodigo;
    private int examenCodigo;
    private String laboratoristaCodigo;
    
    public Resultado(){
        
    }

    public Resultado(int codigo, LocalDate fecha, LocalTime hora, boolean verificado, Binary docuemto, Binary ordeHecha, int pacienteCodigo, String medicoCodigo, int examenCodigo, String laboratoristaCodigo) {
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

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public Binary getDocuemto() {
        return docuemto;
    }

    public void setDocuemto(Binary docuemto) {
        this.docuemto = docuemto;
    }

    public Binary getOrdeHecha() {
        return ordeHecha;
    }

    public void setOrdeHecha(Binary ordeHecha) {
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
