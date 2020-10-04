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
public class DiaLab implements Serializable {
    
    public static final String DIA_LAB_DB_NAME="dia_lab";
    public static final String DB_ID="id";
    public static final String DB_DIA_SEMANA="dia_semana";
    public static final String DB_LABORATORISTA_CODIGO="laboratorista_codigo";
    
    private int id;
    private String diaSemana;
    private String laboratoristaCodigo;
    
    public DiaLab(){
        
    }

    public DiaLab(int id, String diaSemana, String laboratoristaCodigo) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.laboratoristaCodigo = laboratoristaCodigo;
    }

    public DiaLab(String diaSemana, String laboratoristaCodigo) {
        this.diaSemana = diaSemana;
        this.laboratoristaCodigo = laboratoristaCodigo;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getLaboratoristaCodigo() {
        return laboratoristaCodigo;
    }

    public void setLaboratoristaCodigo(String laboratoristaCodigo) {
        this.laboratoristaCodigo = laboratoristaCodigo;
    }
    
    

}
