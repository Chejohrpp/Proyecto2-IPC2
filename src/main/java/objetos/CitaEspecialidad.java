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
public class CitaEspecialidad {
    
    public static final String CITA_ESPECIALIDAD_DB_NAME="cita_especilidad";
    public static final String DB_ID="id";
    public static final String DB_CITA_CODIGO="cita_codigo";
    public static final String DB_ESPECIALIDAD_ID="especialidad_id";
    
    private int id;
    private int citaCodigo;
    private int especialidadId;
    
    public CitaEspecialidad(){
        
    }

    public CitaEspecialidad(int id, int citaCodigo, int especialidadId) {
        this.id = id;
        this.citaCodigo = citaCodigo;
        this.especialidadId = especialidadId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCitaCodigo() {
        return citaCodigo;
    }

    public void setCitaCodigo(int citaCodigo) {
        this.citaCodigo = citaCodigo;
    }

    public int getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(int especialidadId) {
        this.especialidadId = especialidadId;
    }
    
    
    

    
}
