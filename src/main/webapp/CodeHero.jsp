<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code Hero</title>
        <link rel="styleSheet" href="estilo.css">
    </head>
    <body>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            if (session.getAttribute("id") == null) {
                response.sendRedirect("login");
            }else{
             String id = (String)session.getAttribute("id");
        %>
        
        <%--cabecera --%>
        <h2>Nombre de usuario: <%= session.getAttribute("nombreUsuario")%></h2>
        <h3>ID: <%= session.getAttribute("id") %></h3>
        <div class="cabecera">            
            <% String tipo=  session.getAttribute("elTipo").toString();
                if (tipo.equalsIgnoreCase("paciente")){%>
                <form action="controladorPerfilPaciente" method="GET">
                <input type="submit" value="modificar tu perfil">
            </form>
            <% } else if (tipo.equalsIgnoreCase("medico")){%>
            <form action="medico/perfil.jsp">
                <input type="submit" value="modificar tu perfil">
            </form>
            <% } else if (tipo.equalsIgnoreCase("laboratorista")){%>
            <form action="laboratorista/perfil.jsp">
                <input type="submit" value="modificar tu perfil">
            </form>
            <% } else if (tipo.equalsIgnoreCase("Admin")){%>
            <form action="controladorPerfilAdmin" method="GET">
                <input type="submit" value="modificar tu perfil">
            </form>
            <% }%>
            <form action="logout">
                <input type="submit" value="Cerrar sesion">
            </form>
        </div>        
        <a href="CodeHero.jsp"><h1>Code Hero</h1></a>
        <%--Para el paciente --%>
         <% if (tipo.equalsIgnoreCase("paciente")){%>
        <div class="paciente">
            <form action="controladorMedico" method="GET">
                <input type="submit" value="agendar una cita">
            </form>
            <form action="controladorHistorial" method="GET">                
                <input type="submit" value="Historial medico">
            </form>
            <form action="controladorExamen" method="GET">
                <input type="submit" value="agendar un examen medico">
            </form>
            <form action="ControladorCitas" method="GET">
                <input type="submit" value="ver citas medicas">
            </form> 
            <form action="controladorCitasExamen" method="GET">
                <input type="submit" value="ver citas de examenes">
            </form> 
            <form action="paciente/reportesPaciente.jsp">
                <input type="submit" value="Reportes">
            </form> 
        </div>      
        
        
        <%--para el Admin --%>
         <% } else if (tipo.equalsIgnoreCase("Admin")){%>
        <div class="paciente">
            <form action="controladorAddMedico" method="GET">
                <input type="submit" value="agregar medico">
            </form>
            <form action="controladorAddLab" method="GET">
                <input type="submit" value="agregar laboratorista">
            </form>
            <form action="Admin/precioConsulta.jsp">
                <input type="submit" value="cambiar precio a las consultas">
            </form>
            <form action="Admin/crearExamen.jsp">
                <input type="submit" value="Crear examenes">
            </form> 
            <form action="Admin/reportes.jsp">
                <input type="submit" value="reportes">
            </form> 
        </div>      
       
        <%--Para el doctor --%>
        <% } else if (tipo.equalsIgnoreCase("medico")){%>         
        <div class="paciente">
            <form action="medico/informe.jsp">
                <input type="submit" value="Generar informe">
            </form>
            <form action="medico/reportes.jsp">
                <input type="submit" value="Reportes">
            </form>
            
        </div>
        
        <%--Para el laboratorista --%>
        <% } else if (tipo.equalsIgnoreCase("laboratorista")){%>
        <div class="paciente">
            <form action="laboratorista/buscarCita.jsp">
                <input type="submit" value="Subir Resultados">
            </form>
            <form action="laboratorista/reportes.jsp">
                <input type="submit" value="Reportes">
            </form>            
        </div>
        <% }}%>
        
    </body>
</html>
