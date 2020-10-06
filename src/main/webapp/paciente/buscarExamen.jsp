

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Examen</title>
        <style>
            <%@include file="../estilosInteriores.css" %>
        </style>
    </head>
    <body>
         <%@include file="cabecera.html" %>
        <%@include file="../verificarLogin.jsp" %> 
        <div class="datos">
            <form action="controladorExamen"  method="GET">
                <input type="text" name="buscarExamen" placeholder="Busca un tipo de examen">
                <input type="submit" value="Buscar">
            </form>
        </div>
        <div class="datos">
            <table>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>costo</th>
                </tr>
                    <c:forEach items="${examenes}" var="examen">
                        <tr>
                            <td>${examen.codigo}</td>
                            <td>${examen.nombre}</td>
                            <td>${examen.costo}</td>                    

                            <td><a style="color: #0095f6;" href="${pageContext.request.contextPath}/controladorCrearCitaExamen?usuario=${examen.codigo}">Agendar una cita de Examen</a></td>
                        </tr>                              
                    </c:forEach>
                </table>          
        </div>
        
        
    </body>
</html>
