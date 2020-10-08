/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Paciente;

import ConnectionDB.PacienteModelo;
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
@WebServlet("/controladorHistorial")
public class ControladorHistorial extends HttpServlet {
    
    PacienteModelo pacienteModelo = new PacienteModelo();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
            
         try{
            String id = (String) request.getSession().getAttribute("id");
            int codigo = Integer.parseInt(id);
            request.setAttribute("informes", pacienteModelo.todosInformes(codigo));
            
            request.setAttribute("resultados", pacienteModelo.todosExamenes(codigo));
            
            request.getRequestDispatcher("/paciente/historial.jsp").forward(request, response);
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error HistorialPaciente: " + e.getMessage());
        }  
       
     }
}
