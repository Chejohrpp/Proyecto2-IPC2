<%-- 
    Document   : perfil
    Created on : 30/09/2020, 07:46:40 PM
    Author     : sergi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Configura tu perfil</title>
        <link rel="styleSheet" href="estilosInteriores.css">
    </head>
    <body>
        <%@include file="cabecera.html" %>
        <div class="datos">
            <h1>Perfil</h1>
             <%--PACIENTE PERFIL --%>
            <form action="controladorPerfilPaciente" method="POST">
                <%--codigo --%>
                <label>Codigo: ${codigo}</label>
                <br>
                 <%--Nombre de usuario--%>
                <label for="usuario">Nombre</label>
                <input type="text" name="nombre" value="${nombre}" placeholder="Nombre">        
                
                <%--genero --%>
                <label for="genero">Genero</label>
                <select name="genero" id="genero">                    
                    <option value="${genero}">${genero}</option>
                    <option value="Mujer">Mujer</option>
                    <option value="Hombre">Hombre</option>
                </select>
                
                <%--fecha de nacimiento --%>
                <label for="fecha">Fecha de nacimiento</label>
                <input type="date" name="fecha" value="${fecha}">
                
                <%--DPI --%>
                <label for="dpi">DPI</label>
                <input type="text" name="dpi" value="${dpi}" placeholder="DPI">
                
                <%--telefono --%>
                <label for="telefono">Telefono</label>
                <input type="number" name="telefono" value="${telefono}" placeholder="Telefono">
                
                 <%--peso --%>
                <label for="peso">Peso (Kg)</label>
                <input type="number" name="peso" value="${peso}" placeholder="Peso">
                
                 <%--tipo de sangre --%>
                <label for="sangre">Tipo de sangre</label>
                <select name="sangre" id="sangre">
                    <option value="${sangre}">${sangre}<option>
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
                <input type="text" name="email" value="${email}" placeholder="Correo Electronico">
                
                 <%--Contraseña --%>
                <label for="password">Contraseña</label>
                <input type="text" name="pass" value="${pass}" placeholder="Contraseña">
                
                <%--boton --%>
                <input type="submit" value="Guardar datos">                
            </form>
        </div>
    </body>
</html>
