<%-- 
    Document   : verificarLogin
    Created on : 5/10/2020, 01:47:13 AM
    Author     : sergi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    
    if (session.getAttribute("id") == null) {
        response.sendRedirect("Login");
    }
%>

