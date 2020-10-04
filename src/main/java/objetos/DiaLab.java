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
public class DiaLab {
    
    public static final String DIA_LAB_DB_NAME="dia_lab";
    public static final String DB_ID="id";
    public static final String DB_DIA_SEMANA_ID="dia_semana_id";
    public static final String DB_LABORATORISTA_CODIGO="laboratorista_codigo";
    
    private int id;
    private int semanaId;
    private String laboratoristaCodigo;
    
    public DiaLab(){
        
    }

    public DiaLab(int id, int semanaId, String laboratoristaCodigo) {
        this.id = id;
        this.semanaId = semanaId;
        this.laboratoristaCodigo = laboratoristaCodigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemanaId() {
        return semanaId;
    }

    public void setSemanaId(int semanaId) {
        this.semanaId = semanaId;
    }

    public String getLaboratoristaCodigo() {
        return laboratoristaCodigo;
    }

    public void setLaboratoristaCodigo(String laboratoristaCodigo) {
        this.laboratoristaCodigo = laboratoristaCodigo;
    }
    
    

}
