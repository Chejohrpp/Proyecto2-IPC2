/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Admin;

import ConnectionDB.DiaLabModelo;
import ConnectionDB.ExamenModelo;
import ConnectionDB.LaboratoristaModelo;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.DiaLab;
import objetos.Laboratorista;
import objetos.Medico;

/**
 *
 * @author sergi
 */

@WebServlet("/controladorAddLab")
public class ControladorAddLaboratorista extends HttpServlet{
    LaboratoristaModelo laboratoristaModelo = new LaboratoristaModelo();
    ExamenModelo examenModelo = new ExamenModelo();
    DiaLabModelo diaLabModelo = new DiaLabModelo();
    
    
    
    
    @Override
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
         try {
             request.setAttribute("success", 2);
            request.getRequestDispatcher("/Admin/AddLaboratorista.jsp").forward(request, response);
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
            String numRegistro = request.getParameter("numRegistro");
            String dpi = request.getParameter("dpi");
            String telefono = request.getParameter("telefono");
            String examen = request.getParameter("examen");            
            int idExamen = examenModelo.buscarIdExamen(examen);//se necesita el id del examen
             System.out.println(idExamen);
            String email = request.getParameter("email");
            String fecha = request.getParameter("fecha");        
            String pass = request.getParameter("pass");
             System.out.println("llego hata aqui?");
            
            if (nombre != null && codigo != null && pass != null && numRegistro != null && dpi != null && telefono != null && fecha != null && email != null) {  
                
                System.out.println("llego hata aqui??????");
                laboratoristaModelo.addLaboratorista(new Laboratorista(codigo,nombre,numRegistro,dpi,telefono,email,fecha,idExamen,pass));
                
                if (request.getParameter("Lunes") != null) {
                    diaLabModelo.addDiaLab(new DiaLab("Lunes",codigo));                    
                }
                if (request.getParameter("Martes") != null) {
                    diaLabModelo.addDiaLab(new DiaLab("Martes",codigo));                    
                }
                if (request.getParameter("Miercoles") != null) {
                    diaLabModelo.addDiaLab(new DiaLab("Miercoles",codigo));                    
                }
                if (request.getParameter("Jueves") != null) {
                    diaLabModelo.addDiaLab(new DiaLab("Jueves",codigo));                    
                }
                if (request.getParameter("Viernes") != null) {
                    diaLabModelo.addDiaLab(new DiaLab("Viernes",codigo));                    
                }
                if (request.getParameter("Sabado") != null) {
                    diaLabModelo.addDiaLab(new DiaLab("Sabado",codigo));                    
                }
                if (request.getParameter("Domingo") != null) {
                    diaLabModelo.addDiaLab(new DiaLab("Domingo",codigo));                    
                }
                
                
                //request.getRequestDispatcher("Admin/verificacionADD.jsp").forward(request, response);
                response.sendRedirect("Admin/verificacionADD.jsp");
            }else{
                request.setAttribute("success", 1);
                request.getRequestDispatcher("/Admin/AddLaboratorista.jsp").forward(request, response);
            }
            
        } catch (IOException | SQLException |NumberFormatException e) {
            System.out.println("Error User: " + e.getMessage());
            request.setAttribute("success", 0);
            request.getRequestDispatcher("/Admin/AddLaboratorista.jsp").forward(request, response);
        } 
    }
    
}
