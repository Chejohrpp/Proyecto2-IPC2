/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Paciente;

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
@WebServlet("/controladorCitasExamen")
public class controladorCitasExamen extends HttpServlet {
    
    ResultadoModelo resultadoModelo = new ResultadoModelo();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            String id = (String) request.getSession().getAttribute("id");
            request.setAttribute("resultados", resultadoModelo.todasCitasPaciente(Integer.valueOf(id)));
            
            request.getRequestDispatcher("/paciente/citasExamen.jsp").forward(request, response);
            
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error busquedaExamen: " + e.getMessage());
        }
        
     }
}
