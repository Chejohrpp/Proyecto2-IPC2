/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Paciente;

import ConnectionDB.PacienteModelo;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Paciente;

/**
 *
 * @author sergi
 */
@WebServlet("/ControladorPaciente")
public class ControladorPaciente extends HttpServlet {
    
    PacienteModelo pacienteModelo = new PacienteModelo();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
       
     }
     
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try {
            String nombre = request.getParameter("nombre");
            String genero = request.getParameter("generos");
            String fecha = request.getParameter("fecha");
            String dpi = request.getParameter("DPI");
            String telefono = request.getParameter("telefono");
            String peso = request.getParameter("peso");
            String sangre = request.getParameter("sangres");
            String email = request.getParameter("correo");            
            String pass = request.getParameter("pass");
            //pasos para colocar la fecha de String a Date
            
            /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
            LocalDate date = LocalDate.parse(fecha, formatter);*/
            
            if (nombre != null && genero != null && pass != null && fecha != null && dpi != null && telefono != null && peso != null && sangre != null && email != null ) {
                
                long id = pacienteModelo.addPacienteSinCodigo(new Paciente(nombre,genero,fecha,dpi,telefono,Integer.valueOf(peso),sangre,email,pass));
                System.out.println("New ID: " + id);
                request.setAttribute("nombreUsuario", nombre);
                request.setAttribute("id", id);
                 request.getRequestDispatcher("CodeHero.jsp").forward(request, response);
            }
        } catch (IOException | SQLException  e) {
            System.out.println("Error User: " + e.getMessage());
        } 
    }
     
}
