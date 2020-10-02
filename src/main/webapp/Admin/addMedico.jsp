<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Medico</title>
    </head>
    <link rel="styleSheet" href="../estilosInteriores.css">
    <body>
        <%@include file="cabecera.html" %>
        <div class="datos">
            <h2>Agregar Medico</h2>
            <form action="verificarMedico.jsp" method="POST">
                <%-- codigo --%>
                <label for="codigo">Codigo</label>
                <input type="text" name="codigo" placeholder="codigo">  
                <%-- Nombre --%>
                <label for="usuario">Nombre</label>
                <input type="text" name="nombre" placeholder="Nombre">  
                <%-- Numero de colegiado --%>
                <label for="colegiado">No. Colegiado</label>
                <input type="number" name="colegiado" placeholder="No.Colegiado">  
                <%-- DPI --%>
                <label for="dpi">DPI</label>
                <input type="number" name="dpi" placeholder="DPI">  
                <%-- telefono --%>
                <label for="telefono">telefono</label>
                <input type="number" name="telefono" placeholder="telefono">  

                <%-- especialidades --%>
                <label for="usuario">Especialidades</label>
                
                <br>

                <%-- email --%>
                <label for="email">Correo Electronico</label>
                <input type="text" name="email" placeholder="Correo Electronico">  
                <%-- horario --%>
                <label for="usuario">horario de inicio</label>
                <input type="time" name="horarioInicio"> 
                <label for="usuario">horario final</label>
                <input type="time" name="horarioFinal"> 
                <%-- fecha que inicio --%>
                <label for="usuario">fecha en la que inicio</label>
                <input type="date" name="fechaInicio" value="<%= LocalDate.now() %>"> 

                <%--Contraseña --%>
                <label for="contraseña">Contraseña</label>
                <input type="text" name="contraseña" placeholder="Contraseña">                
                <input type="submit" value="Agregar">
            </form>
                
            <form action="../CodeHero.jsp">
                <input type="submit" value="Regresar">
            </form>
                
        </div>
      
        
        
    </body>
</html>
