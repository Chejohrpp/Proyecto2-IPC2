<%-- 
    Document   : perfil
    Created on : 1/10/2020, 08:21:05 PM
    Author     : sergi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
        <link rel="styleSheet" href="estilosInteriores.css">
    </head>    
       <%@include file="cabecera.html" %>
       <div class="datos">
            <h1>Perfil</h1>
            <c:if test="${exitoso == 1}">
            <label>Datos modificados y guardados</label>
            </c:if>
            <form action="controladorPerfilAdmin" method="POST">
                <%--codigo --%>
                <label>Codigo: ${codigo}</label>
                <%--nombre --%>
                <%-- Nombre --%>
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" value="${nombre}" placeholder="Nombre"> 
                <%--dpi --%>
                <label for="dpi">DPI</label>
                <input type="number" name="dpi" value="${dpi}" placeholder="DPI"> 
                <%--password --%>
                <label for="codigo">Contraseña</label>
                <input type="text" name="pass" value="${pass}" placeholder="Contraseña">
                <%--submit --%>
                <input type="submit" value="Guardar">
            </form>
        </div>    
        
    
</html>
