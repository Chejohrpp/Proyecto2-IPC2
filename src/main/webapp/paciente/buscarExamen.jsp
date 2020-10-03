

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Examen</title>
        <link rel="styleSheet" href="../estilosInteriores.css">
    </head>
    <body>
        <%@include file="cabecera.html" %>
        <div class="datos">
            <form action="#"  method="GET">
                <input type="text" name="buscarExamen" placeholder="Busca un tipo de examen">
                <input type="submit" value="Buscar">
            </form>
        </div>        
        
    </body>
</html>
