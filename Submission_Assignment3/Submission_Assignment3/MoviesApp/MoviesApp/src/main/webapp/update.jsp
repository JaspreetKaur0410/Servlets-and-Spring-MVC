<%-- 
    Document   : update
    Created on : 22-Oct-2021, 3:42:31 pm
    Author     : jaspr
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Movie</title>
    </head>
    <body>
        ${searchedmovies}
        <form method="post" action="saveupdates?movieid=${searchedmovies.movieid}">
            <br><br><br>    
            MOVIE ID: <input type="text" name="movieid" value="${searchedmovies.movieid}" disabled=""><br><br>
        TITLE : &nbsp&nbsp<input type="text" name="title" value="${searchedmovies.title}"/><br><br>
        ACTRESS: <input type="text" name="actress" value="${searchedmovies.actress}"/><br><br>
        ACTOR: <input type="text" name="actor" value="${searchedmovies.actor}"/><br><br>
        GENRE: <input type="text" name="genre" value="${searchedmovies.genre}"/><br><br>
        YEAR: <input type="text" name="year" value="${searchedmovies.year}"/><br><br>
        <input type="submit" value="Save Updates"/><br><br>
        </form>
    </body>
</html>
