/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Paciente;

import ConnectionDB.PacienteModelo;
import ConnectionDB.ResultadoModelo;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sergi
 */
@WebServlet("/controladorReporte5ExamenesLab")
public class ControladorReporte5ExamenesLab extends HttpServlet {
    PacienteModelo pacienteModelo = new PacienteModelo();
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
            
         try{
            String id = (String) request.getSession().getAttribute("id");
            int codigo = Integer.parseInt(id);
            
            request.setAttribute("resultados", pacienteModelo.todosExamenesLimit5(codigo));
            
            request.getRequestDispatcher("/paciente/reporte5ExamenesLab.jsp").forward(request, response);
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error HistorialPaciente: " + e.getMessage());
        }  
       
     }
}
