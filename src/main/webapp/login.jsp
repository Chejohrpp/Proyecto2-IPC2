
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code Hero login</title>
        <style>
            <%@include file="estilo.css" %>
        </style>
    </head>
    <body>
        <div class="caja">
            <h1>Code Hero</h1>
            <form action="verificar.jsp" method="POST">
                <%--Nombre de usuario--%>
                <label for="usuario">Usuario</label>
                <input type="text" name="user" placeholder="Usuario">
                <%--Contraseña --%>
                <label for="password">Contraseña</label>
                <input type="password" name="pass" placeholder="Contraseña">
                <%--boton --%>
                <input type="submit" value="Ingresar">
                <%--crear cuenta --%>
                <label>¿No tienes una cuenta?</label>
                <a href="#">Registrate</a>
            </form>
        </div>
        
    </body>
</html>
