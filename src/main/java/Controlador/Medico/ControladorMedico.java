/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Medico;

import ConnectionDB.MedicoModelo;
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
@WebServlet("/controladorMedico")
public class ControladorMedico extends HttpServlet{
    
    MedicoModelo medicoModelo = new MedicoModelo();
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            String name = request.getParameter("buscarMedico");
            if (name == null || (name != null && name.isEmpty())) {
                request.setAttribute("medicos", medicoModelo.todosMedicos());
            } else {
                request.setAttribute("medicos", medicoModelo.todosMedicosNombre(name));
            }
            
            request.getRequestDispatcher("/paciente/buscarMedico.jsp").forward(request, response);
        } catch (SQLException e) {
            System.out.println("Error busquedaMedico: " + e.getMessage());
        }
        
       
     }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
        
       
     }
}
