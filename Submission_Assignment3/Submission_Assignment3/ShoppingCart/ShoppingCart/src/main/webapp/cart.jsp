<%-- 
    Document   : index
    Created on : 23-Oct-2021, 1:11:41 pm
    Author     : jaspr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cart Page</title>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>
        <h4>Cart PAGE</h4>
        <%
            if(session.getAttribute("username") == null){
                response.sendRedirect("login.jsp");
            }
        %>
        <%@include file="includes/foot.jsp" %>
    </body>
</html>
