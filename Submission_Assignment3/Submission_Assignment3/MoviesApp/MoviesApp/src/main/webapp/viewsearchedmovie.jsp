<%-- 
    Document   : viewsearchedmovie
    Created on : 22-Oct-2021, 2:39:01 pm
    Author     : jaspr
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VIEW MOVIE</title>
    </head>
    <body>
       
        The Searched movie is - <br/><br/>
            <TABLE border="1">
                <TR>
                    <TH>Movie ID</th>
                    <TH>Title</th>
                    <TH>Actress</th>
                    <TH>Actor</th>
                    <TH>Genre</th>
                    <TH>Year</th>
                </TR>
                <c:forEach var="movie" items="${searchedmovies}">
                <tr>
                    <td>${movie.movieid}</td>
                    <td>${movie.title}</td>
                    <td>${movie.actress}</td>
                    <td>${movie.actor}</td>
                    <td>${movie.genre}</td>
                    <td>${movie.year}</td>
                </tr>
                </c:forEach>
            </table>
           
   
        <a href="<%=request.getContextPath()%>/search" class="btn btn-success"> Go Back </a>
        <a href="<%= request.getContextPath()%>/list"> List of Movies </a>
    </body>
</html>
