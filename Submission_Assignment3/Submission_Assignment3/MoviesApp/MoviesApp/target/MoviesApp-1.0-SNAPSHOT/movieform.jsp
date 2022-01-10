<%-- 
    Document   : movieform
    Created on : 22-Oct-2021, 4:37:17 am
    Author     : jaspr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="insert">
            <br><br><br>
        MOVIE ID: <input type="text" name="movieid"/><br><br>
        TITLE : &nbsp&nbsp<input type="text" name="title"/><br><br>
        ACTRESS: <input type="text" name="actress"/><br><br>
        ACTOR: <input type="text" name="actor"/><br><br>
        GENRE: <input type="text" name="genre"/><br><br>
        YEAR: <input type="text" name="year"/><br><br>
        <input type="submit" value="Submit"/><br><br>
        </form>
    </body>
</html>
