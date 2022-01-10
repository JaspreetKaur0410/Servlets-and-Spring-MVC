<%-- 
    Document   : search
    Created on : 22-Oct-2021, 1:55:03 pm
    Author     : jaspr
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>SEARCH!</h1>
        <form action="searching" method="post">
            <input type="radio" name="s_movie" value="Search By ID"/>Search By ID<br/>
            <input type="radio" name="s_movie" value="Search By Title"/>Search By Title<br/>
            <input type="radio" name="s_movie" value="Search By Actress"/>Search By Actress<br/><br/>
            <label>Search</label>
            <input type="text" name="searchbyid"/>
            <input type="submit" value="search"/>
        </form><br/><br/>
        
        <a href="<%= request.getContextPath()%>/list"> List of Movies </a>
    </body>
</html>
