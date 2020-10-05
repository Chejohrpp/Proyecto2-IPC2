/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author sergi
 */
public class Medico implements Serializable {
    
     public static final String MEDICO_DB_NAME="medico";
     public static final String DB_CODIGO="codigo";
     public static final String DB_NOMBRE="nombre";
     public static final String DB_COLEGIADO="colegiado";
     public static final String DB_DPI="dpi";
     public static final String DB_TELEFONO="telefono";
     public static final String DB_EMAIL="email";
     public static final String DB_NAME_HORARIO_INICIO="horario_inicio";
     public static final String DB_NAME_HORARIO_FINAL="horario_final";
     public static final String DB_NAME_FECHA_EMPEZO="fecha_empezo";
     public static final String DB_PASSWORD="password";
     
     private String codigo;
     private String nombre;
     private String colegiado;
     private String dpi;
     private String telefono;
     private String email;
     private String horarioInicio;
     private String horarioFinal;
     private String fechaEmpezo;
     private String password;
     
     public Medico(){
         
     }

    public Medico(String codigo, String nombre, String colegiado, String dpi, String telefono, String email, String horarioInicio, String horarioFinal, String fechaEmpezo, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.colegiado = colegiado;
        this.dpi = dpi;
        this.telefono = telefono;
        this.email = email;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.fechaEmpezo = fechaEmpezo;
        this.password = password;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColegiado() {
        return colegiado;
    }

    public void setColegiado(String colegiado) {
        this.colegiado = colegiado;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public String getFechaEmpezo() {
        return fechaEmpezo;
    }

    public void setFechaEmpezo(String fechaEmpezo) {
        this.fechaEmpezo = fechaEmpezo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
     
}
