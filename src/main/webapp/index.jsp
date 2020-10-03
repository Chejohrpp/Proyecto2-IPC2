<%-- 
    Document   : index
    Created on : 28/09/2020, 10:17:24 PM
    Author     : sergi
--%>

<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="ConnectionDB.ReadXML" %>
<%@page import="ConnectionDB.ConnectionDB" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="styleSheet" href="estilosInteriores.css">
    </head>
    
    <body>
        <h1>La base de datos esta vacia</h1>
        <div class="datos">
            <% ReadXML read = new ReadXML(); %>
            <form action="<% read.buscarDato();%>">
                <input type="submit" value="Buscar archivo XML">                
            </form>            
        </div>
    </body>
</html>
