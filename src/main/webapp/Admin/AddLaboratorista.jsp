<%-- 
    Document   : AddLaboratorista
    Created on : 1/10/2020, 05:23:28 PM
    Author     : sergi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Laboratorista</title>
        <link rel="styleSheet" href="../estilosInteriores.css">
    </head>
    <body>
        <%@include file="cabecera.html" %>
        <div class="datos">
            <h2>Agregar Laboratorista</h2>
            <form action="verificarLab.jsp">
                <%-- codigo --%>
                <label for="codigo">Codigo</label>
                <input type="text" name="codigo" placeholder="codigo">  
                <%-- Nombre --%>
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" placeholder="Nombre">  
                <%-- numero de registro ante el ministerio de salud --%>
                <label for="numRegistro">Numero de registro ante el ministerio de salud</label>
                <input type="number" name="numRegistro" placeholder="Numero de registro">  
                <%-- DPI --%>
                <label for="dpi">DPI</label>
                <input type="number" name="dpi" placeholder="DPI">  
                <%-- telefono --%>
                <label for="telefono">Telefono</label>
                <input type="number" name="telefono" placeholder="Telefono">  
                <%-- Examen --%>
                <label for="examen">Tipo de Examen</label>
                 <select name="examen" id="tipoExamen">
                <% for(int i = 0; i<=10;i++){%>               
                    <option>hola</option>                
                <% } %>
                </select>
                <%-- Dias --%>
                <label for="dias">Dias de trabajo</label> <br>
                <div class="radios">
                    <label><input type="radio" name="Lunes" value="1"/>Lunes</label><br>
                    <label><input type="radio" name="Martes" value="1"/>Martes</label><br>
                    <label><input type="radio" name="Miercoles" value="1"/>Miercoles</label><br>
                    <label><input type="radio" name="Jueves" value="1"/>Jueves</label><br>
                    <label><input type="radio" name="Viernes" value="1"/>Viernes</label><br>
                    <label><input type="radio" name="Sabado" value="1"/>Sabado</label><br>
                    <label><input type="radio" name="Domingo" value="1"/>Domingo</label> <br>
                </div>                               
                <%-- email --%>
                <label for="codigo">Corrreo Electronico</label>
                <input type="text" name="email" placeholder="Correo Electronico">  
                
                <%-- fecha que inicio --%>
                <label for="fecha">Fecha de Inicio</label>
                <input type="date" name="fecha" value="<%= java.time.LocalDate.now()%>">  
                
                <%-- contraseña --%>
                <label for="codigo">Contraseña</label>
                <input type="text" name="contraseña" placeholder="Contraseña">  
                <input type="submit" value="Registrar">
            </form>
             <form action="../CodeHero.jsp">
                <input type="submit" value="Regresar">
            </form>
        </div>
    </body>
</html>
