<%-- 
    Document   : index
    Created on : 23-Oct-2021, 1:11:41 pm
    Author     : jaspr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>logout Page</title>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>
        <%
            if(session.getAttribute("username") != null){
                session.invalidate();
                response.sendRedirect("login.jsp");
         %>
         <h1> USER LOGGED OUT </h1>
         <%
         }
            else {
                    response.sendRedirect("login.jsp");
                }
        %>
        <%@include file="includes/foot.jsp" %>
    </body>
</html>
