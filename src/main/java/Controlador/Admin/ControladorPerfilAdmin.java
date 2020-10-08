/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Admin;

import ConnectionDB.AdminModelo;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Admin;

/**
 *
 * @author sergi
 */
@WebServlet("/controladorPerfilAdmin")
public class ControladorPerfilAdmin  extends HttpServlet{
    AdminModelo adminModelo = new AdminModelo();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            String codigo = (String)request.getSession().getAttribute("id");
            
            Admin admin = adminModelo.obtenerAdmin(codigo);            
            request.setAttribute("codigo",admin.getCodigo());
            request.setAttribute("nombre",admin.getNombre());
            request.setAttribute("dpi", admin.getDpi());
            request.setAttribute("pass", admin.getPassword());                          
            
            request.getRequestDispatcher("/Admin/perfil.jsp").forward(request, response);
        } catch (SQLException e) {
            System.out.println("Error busquedaMedico: " + e.getMessage());
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            String codigo = (String)request.getSession().getAttribute("id");
            String nombre = request.getParameter("nombre");
            String dpi = request.getParameter("dpi");
            String pass = request.getParameter("pass");
            
            adminModelo.modAdmin(new Admin(codigo,nombre,dpi,pass));
            request.getSession().setAttribute("nombreUsuario", nombre);
            
            response.sendRedirect("CodeHero.jsp");
        } catch (SQLException e) {
            System.out.println("Error addAdmin: " + e.getMessage());
        }
    }
    
}
