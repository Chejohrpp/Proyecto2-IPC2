
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code Hero login</title>
        <style>
            <%@include file="estilo.css" %>
            #error {
                color: red;
            }
        </style>
    </head>
    <body>        
        <div class="caja">
            <h1>Code Hero</h1>
            
            <c:if test="${success == 0}">
            <label id="error">Usuario o Contraseña Incorrecto</label>
            </c:if>
            
            <form action="login" method="POST">
                <%--Nombre de usuario--%>
                <label for="usuario">ID</label>
                <input type="text" name="user" placeholder="ID">
                <%--Contraseña --%>
                <label for="password">Contraseña</label>
                <input type="password" name="pass" placeholder="Contraseña">
                <%--boton --%>
                <input type="submit" value="Ingresar">                
            </form>
            <%--crear cuenta --%>
            <label>¿No tienes una cuenta?</label>
            <a href="registrarse.jsp">Registrate</a>
        </div>        
    </body>
</html>
