<%-- 
    Document   : Errors
    Created on : 22-Oct-2021, 3:50:45 am
    Author     : jaspr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><% exception.getMessage(); %></h1>
    </body>
</html>
