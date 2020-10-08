/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Admin;

import ConnectionDB.ConsultaModelo;
import ConnectionDB.MedicoEspecialidadModelo;
import ConnectionDB.MedicoModelo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Especialidad;
import objetos.Medico;
import objetos.MedicoEspecialidad;
import objetos.Paciente;

/**
 *
 * @author sergi
 */
@WebServlet("/controladorAddMedico")
public class ControladorAddMedico  extends HttpServlet{
    MedicoModelo medicoModelo = new MedicoModelo();
    ConsultaModelo consultaModelo = new ConsultaModelo();
    MedicoEspecialidadModelo medicoEspecialidadModelo = new MedicoEspecialidadModelo();
    
    @Override
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
         try {
             request.setAttribute("success", 2);
            request.getRequestDispatcher("/Admin/addMedico.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            System.out.println("Login Error: " + e.getMessage());
            e.printStackTrace();
        }
     }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try {
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            String colegiado = request.getParameter("colegiado");
            String dpi = request.getParameter("dpi");
            String telefono = request.getParameter("telefono");
            String email = request.getParameter("email");
            String horarioInicio = request.getParameter("horarioInicio");
            String horarioFinal = request.getParameter("horarioFinal");
            String fechaEmpezo = request.getParameter("fechaEmpezo");            
            String pass = request.getParameter("pass");
            
            
            if (nombre != null && codigo != null && pass != null && fechaEmpezo != null && dpi != null && telefono != null && colegiado != null && horarioInicio != null && email != null) {                
                medicoModelo.addMedico(new Medico(codigo,nombre,colegiado,dpi,telefono,email,horarioInicio,horarioFinal,fechaEmpezo,pass));  
                
                
                List<Especialidad> especialidad = consultaModelo.todasEspecialidades();
                for (int i = 0; i < especialidad.size(); i++) {
                    if (request.getParameter(especialidad.get(i).getNombre()) != null) {
                        int idEspecialidad = consultaModelo.buscarIdEspecialidad(especialidad.get(i).getNombre());
                        medicoEspecialidadModelo.addMedicoEspecialidad(new MedicoEspecialidad(codigo,idEspecialidad));
                    }
                }
                
                //request.getRequestDispatcher("Admin/verificacionADD.jsp").forward(request, response);
                response.sendRedirect("Admin/verificacionADD.jsp");
            }else{
                request.setAttribute("success", 1);
                request.getRequestDispatcher("Admin/addMedico.jsp").forward(request, response);
            }
            
        } catch (IOException | SQLException |NumberFormatException e) {
            System.out.println("Error User: " + e.getMessage());
            request.setAttribute("success", 0);
            request.getRequestDispatcher("Admin/addMedico.jsp").forward(request, response);
        } 
    }
}
