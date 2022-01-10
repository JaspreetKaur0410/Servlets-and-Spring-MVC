<%-- 
    Document   : index
    Created on : 23-Oct-2021, 1:11:41 pm
    Author     : jaspr
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cart Page</title>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>

        <c:if test="${empty sessionScope.user}">
             <% response.sendRedirect("signin.jsp"); %>
        </c:if>

        <h4 align="center">Your Cart</h4>
        <c:choose>

            <c:when test="${!empty items}">
                <TABLE BORDER=""1 align="center">
                    <TR><TH>ITEMS</TH>
                        <Th>ACTIONS</th></tr>
                            <c:forEach var="i" items="${items}">

                        <tr>
                            <td>
                                ${i}
                            </td>
                            <td>
                                <form method="get" action="<%= request.getContextPath()%>/addtocart/remove?item=${i}">
                                    <input type="hidden" name="item" value="${i}"/>
                                    <input type="submit" value="remove"/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </TABLE>
            </c:when>
            <c:when test="${empty items}">
                <h1 align="center">Add Items To Cart!</h1>
            </c:when>
        </c:choose>

        <%@include file="includes/foot.jsp" %>

    </body>
</html>
