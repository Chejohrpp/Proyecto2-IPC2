<%-- 
    Document   : index
    Created on : 28/09/2020, 10:17:24 PM
    Author     : sergi
--%>

<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ConnectionDB.ConnectionDB" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% ConnectionDB conexionDB = new ConnectionDB();
            Connection connection;
        %>
        <h1><%= conexionDB.verificar() %></h1>
    </body>
</html>
