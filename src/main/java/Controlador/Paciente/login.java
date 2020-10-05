/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Paciente;

import ConnectionDB.*;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.*;

/**
 *
 * @author sergi
 */
@WebServlet("/login")
public class login extends HttpServlet {
    
    PacienteModelo pacienteModelo = new PacienteModelo();
    AdminModelo adminModelo = new AdminModelo();
    MedicoModelo medicoModelo = new MedicoModelo();
    LaboratoristaModelo laboratoristaModelo = new LaboratoristaModelo();
    
    @Override
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
         try {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            System.out.println("Login Error: " + e.getMessage());
            e.printStackTrace();
        }
     }
    @Override
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try {
            String id = request.getParameter("user");
            String pass = request.getParameter("pass");
            Paciente paciente = null;
            
            try{
                paciente = pacienteModelo.verificarLogin(Integer.parseInt(id), pass);
            }catch(Exception e){}
            
             Admin admin = adminModelo.verificarLogin(id,pass);
             Medico medico = medicoModelo.verificarLogin(id,pass);
             Laboratorista laboratorista = laboratoristaModelo.verificarLogin(id, pass);
            
            if (paciente != null) {
                request.getSession().setAttribute("id", id);
                request.getSession().setAttribute("nombreUsuario", paciente.getNombre());
                request.getSession().setAttribute("elTipo","paciente");                
                response.sendRedirect(request.getContextPath() + "/CodeHero.jsp");
            }else if(admin != null){
                request.getSession().setAttribute("id", id);
                request.getSession().setAttribute("nombreUsuario", admin.getNombre());
                request.getSession().setAttribute("elTipo","admin");                
                response.sendRedirect(request.getContextPath() + "/CodeHero.jsp");
                
            } else if(medico != null){
                request.getSession().setAttribute("id", id);
                request.getSession().setAttribute("nombreUsuario", medico.getNombre());
                request.getSession().setAttribute("elTipo","medico");                
                response.sendRedirect(request.getContextPath() + "/CodeHero.jsp");
                
            } else if(laboratorista != null){
                request.getSession().setAttribute("id", id);
                request.getSession().setAttribute("nombreUsuario", laboratorista.getNombre());
                request.getSession().setAttribute("elTipo","laboratorista");                
                response.sendRedirect(request.getContextPath() + "/CodeHero.jsp");
                
            } else {
                request.setAttribute("success", 0);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (SQLException | IOException e) {
            System.out.println("Login Error: " + e.getMessage());
            e.printStackTrace();
        }
     }
    
}
