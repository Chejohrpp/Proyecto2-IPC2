<%-- 
    Document   : verificar
    Created on : 29/09/2020, 01:54:46 AM
    Author     : sergi
--%>

<%@page import="ConnectionDB.ReadXML"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrate</title>
        <link rel="styleSheet" href="estilosInteriores.css">
    </head>
    <body>
        
        <div class="datos">
            <h1>Su registro se ha completado Ya puedes iniciar sesion</h1>
            <h2>Su ID para ingresar al sistema es: ${id} </h2>
            <form action="login.jsp">
                <input type="submit" value="Inicia Sesion">
            </form>
        </div>
        
    </body>
</html>
