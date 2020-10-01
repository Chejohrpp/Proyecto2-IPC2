<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code Hero</title>
        <style>
            <%@include file="estilo.css" %>
        </style>
    </head>
    <body>
        <%--cabecera --%>
        
        <h2>Nombre del usuario</h2>
        <h3>ID del usuario</h3>
        <div class="cabecera">
            <form action="paciente/perfil.jsp">
                <input type="submit" value="modificar tu perfil">
            </form>
        </div>
        <a href="CodeHero.jsp"><h1>Code Hero</h1></a>   
        
        <%--Para el paciente --%>
        <div class="paciente">
            <form action="paciente/buscarMedico.jsp">
                <input type="submit" value="agendar una cita">
            </form>
            <form action="paciente/historial.jsp">
                <input type="submit" value="Historial medico">
            </form>
            <form action="paciente/buscarExamen.jsp">
                <input type="submit" value="agendar un examen medico">
            </form>
            <form action="paciente/reportesPaciente.jsp">
                <input type="submit" value="Reportes">
            </form>            
        </div>
        
        <%--para el Admin --%>        
       
        <%--Para el doctor --%>
        
        <%--Para el laboratorista --%>
        
        
    </body>
</html>
