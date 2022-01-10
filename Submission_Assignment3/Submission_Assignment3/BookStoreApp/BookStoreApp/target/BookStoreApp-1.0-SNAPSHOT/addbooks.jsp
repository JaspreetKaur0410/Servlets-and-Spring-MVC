<%-- 
    Document   : addbooks
    Created on : 22-Oct-2021, 10:35:20 pm
    Author     : jaspr
--%>
<%@page import="com.Bean.BooksBean"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form method="post" action="addbook">
            <TABLE border="1">
            <c:forEach var="i" begin="1" end="${countbooks}">
                <tr>
                    <h4> ENTER DETAILS FOR BOOK ${i}  </h4>
                </tr>
                <tr name="id" value=${i}>
                    <label> ISBN </label>
                    <input type="text" name="isbn"/>
                    <label> TITLE </label>
                    <input type="text" name="title"/>
                    <label> Author </label>
                    <input type="text" name="author"/>
                    <label> Price </label>
                    <input type="text" name="price"/>
                    <input type="hidden" name="countbooks" value="${countbooks}"/>
            </tr>
            </c:forEach><br/>
            <input type="submit" value="submit"/>
            </TABLE>
        </form>
    </body>
</html>
