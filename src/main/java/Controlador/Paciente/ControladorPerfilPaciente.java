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
import objetos.Admin;
import objetos.Paciente;

/**
 *
 * @author sergi
 */
@WebServlet("/controladorPerfilPaciente")
public class ControladorPerfilPaciente extends HttpServlet{
    PacienteModelo pacienteModelo = new PacienteModelo();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            String codigo = (String)request.getSession().getAttribute("id");
            
            Paciente paciente = pacienteModelo.obtenerPaciente(Integer.valueOf(codigo));
            request.setAttribute("codigo",paciente.getCodigo());
            request.setAttribute("nombre",paciente.getNombre());
            request.setAttribute("dpi", paciente.getDpi());
            request.setAttribute("genero", paciente.getGenero());
            request.setAttribute("telefono", paciente.getTelefono());
            request.setAttribute("fecha", paciente.getFechaNacimiento());
            request.setAttribute("peso", paciente.getPeso());
            request.setAttribute("sangre", paciente.getSangre());
            request.setAttribute("email", paciente.getEmail());
            request.setAttribute("pass", paciente.getPassword());                          
            
            request.getRequestDispatcher("/paciente/perfil.jsp").forward(request, response);
        } catch (SQLException e) {
            System.out.println("Error busquedaMedico: " + e.getMessage());
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            String codigo = (String)request.getSession().getAttribute("id");
            int idCodigo = Integer.valueOf(codigo);
            String nombre = request.getParameter("nombre");
            String genero = request.getParameter("genero");
            String fechaNacimiento = request.getParameter("fecha");
            String dpi = request.getParameter("dpi");
            String telefono = request.getParameter("telefono");
            String peso = request.getParameter("peso");
            String sangre = request.getParameter("sangre");
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            
            pacienteModelo.modPaciente(new Paciente(idCodigo,nombre,genero,fechaNacimiento,dpi,telefono,Integer.valueOf(peso),sangre,email,pass));
            request.getSession().setAttribute("nombreUsuario", nombre);
            
            response.sendRedirect("CodeHero.jsp");
        } catch (SQLException e) {
            System.out.println("Error Mod Paciente: " + e.getMessage());
        }
    }
    
}
