<%-- 
    Document   : index
    Created on : 28/09/2020, 10:17:24 PM
    Author     : sergi
--%>

<%@page import="ConnectionDB.ReadXML"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ConnectionDB.AdminModelo" %>
<%@page import="ConnectionDB.ConnectionDB" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="styleSheet" href="estilosInteriores.css">
    </head>
    
    <body>
        <% AdminModelo adminModelo = new AdminModelo(); 
         if (adminModelo.cantAdmins() == 0){ %>
        
        <h1>La base de datos esta vacia</h1>
        <div class="datos">
            
            <form action="DatosSubidos.jsp">
                <input type="submit" value="Buscar archivo XML">                
            </form>        
        </div>        
        
        <% } else{ %>
        
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

            if (session.getAttribute("id") == null) {
                response.sendRedirect("login");
            }           
        %>
        
        <% } %>
        
    </body>
</html>
