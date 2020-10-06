<%-- 
    Document   : historial
    Created on : 30/09/2020, 07:47:07 PM
    Author     : sergi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>historial</title>
        <style>
            <%@include file="../estilosInteriores.css" %>
        </style>
    </head>
    <body>
         <%@include file="cabecera.html" %>
        <%@include file="../verificarLogin.jsp" %>  
        <div class="datos">
            <h2>Historial</h2>                
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
        <div class="datos">
            <h3>Examenes Realizados</h3> 
            <table>
            <tr>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Codigo</th>
                <th>Tipo de Examen</th>
            </tr>
                <c:forEach items="${resultados}" var="resultado">
                    <tr>
                        <td>${resultado.fecha}</td>
                        <td>| ${resultado.hora}</td>
                        <td>| ${resultado.codigo}</td>
                        <td>| ${resultado.nombreExamen}</td>
                    </tr>                              
                </c:forEach>
            </table>
        </div>
    </body>
</html>
