<%-- 
    Document   : DatosSubidos
    Created on : 4/10/2020, 02:47:47 PM
    Author     : sergi
--%>

<%@page import="ConnectionDB.ReadXML"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos Subidos</title>
        <link rel="styleSheet" href="estilosInteriores.css">
    </head>
    <body>        
        
        <div class="datos">
            <h1>Los Registros Fueron Subidos a la Base de Datos</h1>
            <h2>Ahora puede ir a iniciar su Sesion</h2>
            <form action="login.jsp">
                <input type="submit" value="Inicia Sesion">
            </form>
            <% ReadXML readXML = new ReadXML(); %>
            <form action="<% readXML.buscarDato();%>">
                <input type="submit" value="Buscar Otro Doucumento XML">
            </form>
        </div>
        
    </body>
</html>
