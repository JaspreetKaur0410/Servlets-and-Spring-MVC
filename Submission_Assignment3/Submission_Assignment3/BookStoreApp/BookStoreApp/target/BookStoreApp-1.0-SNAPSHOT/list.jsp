<%-- 
    Document   : list
    Created on : 22-Oct-2021, 11:02:28 pm
    Author     : jaspr
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BOOKS List</title>
    </head>
    <body>
        <a href="<%=request.getContextPath()%>" class="btn btn-success">Add Books</a><br/><br/>
        <TABLE border="3">
            <TR>
                <TH>ISBN</th>
                <TH>Title</th>
                <TH>Author</th>
                <TH>Price</th>
            </TR>

            <c:forEach var="book" items="${listBooks}">
                <tr>
                    <td>${book.isbn}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                </tr>
            </c:forEach><br/><br/>
        </TABLE>
        
    </body>
</html>
