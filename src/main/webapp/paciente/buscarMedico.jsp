<%-- 
    Document   : buscarMedico
    Created on : 30/09/2020, 07:34:21 PM
    Author     : sergi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            <%@include file="../estilosInteriores.css" %>
        </style>
    </head>
    <body>
        <%@include file="cabecera.html" %>
        <%@include file="../verificarLogin.jsp" %>        
        <div class="datos">
            
            <form action="controladorMedico" method="GET">
                <input type="text" name="buscarMedico" placeholder="Busca un Medico">
                <input type="submit" value="Buscar">
            </form>

        </div>          
                <div class="informacion">
                    <table>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>DPI</th>
                        <th>correo electronico</th>
                        <th>Colegiado</th>
                        <th> horario de inicio</th>
                        <th>horario de salida</th>
                        <th>Fecha que empezo</th>
                    </tr>
                        <c:forEach items="${medicos}" var="medico">
                            <tr>
                                <td>${medico.codigo}</td>
                                <td>| ${medico.nombre}</td>
                                <td>| ${medico.dpi}</td>
                                <td>| ${medico.email}</td>
                                <td>| ${medico.colegiado}</td>
                                <td>| ${medico.horarioInicio}</td>
                                <td>| ${medico.horarioFinal}</td>
                                <td>| ${medico.fechaEmpezo}</td>                     

                                <td><a href="${pageContext.request.contextPath}/controladorCrearCita?usuario=${medico.codigo}">Agendar una cita</a></td>
                            </tr>                              
                        </c:forEach>
                    </table>
                </div>
            </form
        
    </body>
</html>
