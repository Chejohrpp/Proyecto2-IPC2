<%-- 
    Document   : reporte5Consultas
    Created on : 8/10/2020, 12:30:33 PM
    Author     : sergi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte</title>
     <style>
            <%@include file="../estilosInteriores.css" %>
        </style>
    </head>
    <body>
         <%@include file="cabecera.html" %>
        <%@include file="../verificarLogin.jsp" %>  
        <div class="datos">
            <h2>Últimas 5 consultas realizadas</h2>                
        </div> 
        <div class="datos">
            <h3>Consultas Medicas</h3> 
            <table>
            <tr>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Codigo</th>
                <th>Nombre del Medico</th>
            </tr>
                <c:forEach items="${informes}" var="informe">
                    <tr>
                        <td>${informe.fecha}</td>
                        <td>| ${informe.hora}</td>
                        <td>| ${informe.coidigo}</td>
                        <td>| ${informe.nombreMedico}</td>
                    </tr>                              
                </c:forEach>
            </table>
        </div>        
</html>
