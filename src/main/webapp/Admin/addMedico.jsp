<%@page import="objetos.Especialidad"%>
<%@page import="java.util.List"%>
<%@page import="ConnectionDB.ConsultaModelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Medico</title>
    </head>
    <link rel="styleSheet" href="estilosInteriores.css">
    <style>            
            #error {
                color: red;
            }
        </style>
    
    <body>
        <%@include file="cabecera.html" %>
        <div class="datos">
            <h2>Agregar Medico</h2>
            
             <c:if test="${success == 0}">
            <label id="error">Error, no se logro llenar registrar al medico, Vuelva a intentarlo</label>
            </c:if>
            <c:if test="${success == 1}">
            <label id="error">Ingrese todos los valores requeridos</label>
            </c:if>
            <form action="controladorAddMedico" method="POST">
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
                <% 
                    ConsultaModelo consultaModelo = new ConsultaModelo();
                    List<Especialidad> especialidades = consultaModelo.todasEspecialidades();
                    for (int i = 0; i < especialidades.size(); i++) { %>
                    <label><input type="radio" name="<%=especialidades.get(i).getNombre()%>" value="1"/><%=especialidades.get(i).getNombre()%></label><br>                            
                <% }  %>
                
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
                <input type="date" name="fechaEmpezo" value="<%= LocalDate.now() %>"> 

                <%--Contraseña --%>
                <label for="contraseña">Contraseña</label>
                <input type="password" name="pass" placeholder="Contraseña">                
                <input type="submit" value="Agregar">
            </form>
                
            <form action="CodeHero.jsp">
                <input type="submit" value="Regresar">
            </form>
                
        </div>
      
        
        
    </body>
</html>
