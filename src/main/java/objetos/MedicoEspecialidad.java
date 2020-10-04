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
public class MedicoEspecialidad {
    
    public static final String MEDICO_ESPECIALIDAD_DB_NAME="medico_especialidad";
    public static final String DB_ID="id";
    public static final String DB_MEDICO_CODIGO="medico_codigo";
    public static final String DB_ESPECIALIDAD_ID="especialidad_id";
    
    private int id;
    private String medicoCodigo;
    private int especialidadId;
    
    public MedicoEspecialidad(){
        
    }

    public MedicoEspecialidad(int id, String medicoCodigo, int especialidadId) {
        this.id = id;
        this.medicoCodigo = medicoCodigo;
        this.especialidadId = especialidadId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicoCodigo() {
        return medicoCodigo;
    }

    public void setMedicoCodigo(String medicoCodigo) {
        this.medicoCodigo = medicoCodigo;
    }

    public int getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(int especialidadId) {
        this.especialidadId = especialidadId;
    }
    
}
