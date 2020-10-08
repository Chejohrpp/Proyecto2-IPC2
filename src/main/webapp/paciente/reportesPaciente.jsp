<%-- 
    Document   : reportesPaciente
    Created on : 30/09/2020, 07:47:40 PM
    Author     : sergi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reportes</title>
        <link rel="styleSheet" href="../estilosInteriores.css">
    </head>
    <body>
        <a href="../CodeHero.jsp"><h1>Code Hero</h1></a>
        <div class="datos">
            <h2>Reportes</h2>
            <form action="#">
                <input type="submit" value="Últimos 5 exámenes de laboratorio realizados.">
            </form>
             <form action="#">
                <input type="submit" value="Exámenes realizados de un tipo en específico dentro de un intervalo de tiempo.">
            </form>
             <form action="#">
                <input type="submit" value="Últimas 5 consultas realizadas.">
            </form>
             <form action="#">
                <input type="submit" value="Consultas realizadas con un médico en específico dentro de un intervalo de tiempo..">
            </form>
        </div>
    </body>
</html>
