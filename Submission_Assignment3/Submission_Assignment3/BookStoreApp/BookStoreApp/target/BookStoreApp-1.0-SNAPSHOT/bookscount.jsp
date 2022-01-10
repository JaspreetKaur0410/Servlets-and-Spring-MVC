<%-- 
    Document   : bookscount
    Created on : 22-Oct-2021, 10:11:22 pm
    Author     : jaspr
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books</title>
    </head>
    <body>
        <a href="<%=request.getContextPath()%>/list" class="btn btn-success">See List of Books</a><br/><br/>
        <h1>How many books do you want to add?</h1>
        <form method="post" action="add">
         <input type="text" name="countbooks" />
         <input type="submit" name="submit" />
        </form>
    </body>
</html>
