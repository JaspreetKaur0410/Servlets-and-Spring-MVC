<%-- 
    Document   : inserted
    Created on : 22-Oct-2021, 3:49:25 am
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
        <a href="<%= request.getContextPath()%>/list"> Movies </a>
        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add Movie</a>
        <a href="<%=request.getContextPath()%>/search" class="btn btn-success">Search Movie</a>
        <br><br>

        <TABLE border="3">
            <TR>
                <TH>Movie ID</th>
                <TH>Title</th>
                <TH>Actress</th>
                <TH>Actor</th>
                <TH>Genre</th>
                <TH>Year</th>
                <TH>ACTIONS</th>
            </TR>

            <c:forEach var="movie" items="${listmovies}">
                <tr id=${movie.movieid}>
                    <td>${movie.movieid}</td>
                    <td>${movie.title}</td>
                    <td>${movie.actress}</td>
                    <td>${movie.actor}</td>
                    <td>${movie.genre}</td>
                    <td>${movie.year}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/update?movieid=${movie.movieid}" class="btn btn-success" id=${movie.movieid}>update</a>
                        <a href="<%=request.getContextPath()%>/delete?movieid=${movie.movieid}" class="btn btn-success" id=${movie.movieid}>delete</a>
                    </td>
                </tr>
            </c:forEach><br/><br/>
        </TABLE>
    </body>
</html>
