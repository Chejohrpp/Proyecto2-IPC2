<%-- 
    Document   : citasMedico
    Created on : 2/10/2020, 07:33:53 PM
    Author     : sergi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citas Medicas</title>
        <style>
            <%@include file="../estilosInteriores.css" %>
        </style>
    </head>
    <body>
         <%@include file="cabecera.html" %>
        <%@include file="../verificarLogin.jsp" %> 
        <div class="datos">
            <h2>Citas Medicas</h2>            
        </div>
        <div class="datos">
            <table>
                <tr>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Codigo</th>
                    <th>Nombre del medico</th>
                </tr>
                    <c:forEach items="${citas}" var="cita">
                        <tr>
                            <td>${cita.fecha}</td>
                            <td>| ${cita.hora}</td>
                            <td>| ${cita.codigo}</td>                 
                            <td>| ${cita.nombreMedico}</td> 
                        </tr>                              
                    </c:forEach>
                </table>          
        </div>
</html>
