<%-- 
    Document   : registrarse
    Created on : 29/09/2020, 01:57:29 AM
    Author     : sergi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code Hero Registrate</title>
        <style>
            <%@include file="estilo.css" %>
        </style>
    </head>
    <body>       
        <div class="cajaRegistro">
            <h1>Code Hero</h1>
             <h2>Registrate</h2>
            <form action="subirRegistro.jsp" method="POST">
                 <%--Nombre de usuario--%>
                <label for="usuario">Nombre</label>
                <input type="text" name="nombre" placeholder="Nombre">        
                
                <%--genero --%>
                <label for="geneero">Genero</label>
                <select name="generos" id="genero">
                    <option value="Mujer">Mujer</option>
                    <option value="Hombre">Hombre</option>
                </select>
                
                <%--fecha de nacimiento --%>
                <label for="fecha">Fecha de nacimiento</label>
                <input type="date" name="fecha" value="2000-01-01">
                
                <%--DPI --%>
                <label for="dpi">DPI</label>
                <input type="text" name="DPI" placeholder="DPI">
                
                <%--telefono --%>
                <label for="telefono">Telefono</label>
                <input type="number" name="telefono" placeholder="Telefono">
                
                 <%--peso --%>
                <label for="peso">Peso (Kg)</label>
                <input type="number" name="peso" placeholder="Peso">
                
                 <%--tipo de sangre --%>
                <label for="sangre">Tipo de sangre</label>
                <select name="sangres" id="sangre">
                    <option value="O+">O+</option>
                    <option value="O-">O-</option>
                    <option value="A-">A-</option>
                    <option value="A+">A+</option>
                    <option value="B-">B-</option>
                    <option value="B+">B+</option>
                    <option value="AB-">AB-</option>
                    <option value="AB+-">AB+</option>                    
                </select>
                
                 <%--correo electronico --%>
                <label for="correo">Correo electronico</label>
                <input type="text" name="correo" placeholder="Correo Electronico">
                
                 <%--Contraseña --%>
                <label for="password">Contraseña</label>
                <input type="password" name="pass" placeholder="Contraseña">
                
                <%--boton --%>
                <input type="submit" value="Registrarse">
                <%--crear cuenta --%>
                <label>Ya posees una cuenta</label>
                <a href="login.jsp">Inicia sesion</a>
            </form>
        </div>

    </body>
</html>
