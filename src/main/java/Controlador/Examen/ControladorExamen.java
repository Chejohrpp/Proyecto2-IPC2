/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Examen;

import ConnectionDB.ExamenModelo;
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
@WebServlet("/controladorExamen")
public class ControladorExamen extends HttpServlet  {
    
    ExamenModelo examenModelo = new ExamenModelo();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            String name = request.getParameter("buscarExamen");
            if (name == null || (name != null && name.isEmpty())) {
                request.setAttribute("examenes", examenModelo.todosExamenes());
            } else {
                request.setAttribute("examenes", examenModelo.todosExamenesNombre(name));
            }
            
            request.getRequestDispatcher("/paciente/buscarExamen.jsp").forward(request, response);
        } catch (SQLException e) {
            System.out.println("Error busquedaExamen: " + e.getMessage());
        }
        
       
     }
}
