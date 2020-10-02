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
        <%@include file="paciente/cabecera.html" %>
        
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
            <form action="paciente/citasMedicas.jsp">
                <input type="submit" value="ver citas medicas">
            </form> 
            <form action="paciente/citasExamen.jsp">
                <input type="submit" value="ver citas de examenes">
            </form> 
            <form action="paciente/reportesPaciente.jsp">
                <input type="submit" value="Reportes">
            </form> 
        </div>      
        
        <%--para el Admin --%>
        
        <div class="paciente">
            <form action="Admin/addMedico.jsp">
                <input type="submit" value="agregar medico">
            </form>
            <form action="Admin/AddLaboratorista.jsp">
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
        
         
        <div class="paciente">
            <form action="medico/informe.jsp">
                <input type="submit" value="Generar informe">
            </form>
            <form action="medico/reportes.jsp">
                <input type="submit" value="Reportes">
            </form>
            
        </div>
        
        <%--Para el laboratorista --%>
        
        <div class="paciente">
            <form action="laboratorista/informe.jsp">
                <input type="submit" value="subir Resultados">
            </form>
            <form action="laboratorista/reportes.jsp">
                <input type="submit" value="Reportes">
            </form>
            
        </div>
        
    </body>
</html>
