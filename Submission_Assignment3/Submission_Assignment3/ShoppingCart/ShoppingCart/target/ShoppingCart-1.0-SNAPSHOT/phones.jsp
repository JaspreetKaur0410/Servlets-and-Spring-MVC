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
        <h4>Phones PAGE</h4>
        <h3>${sessionScope.bookslist}</h3>
        <%
            if(session.getAttribute("username") == null){
                response.sendRedirect("login.jsp");
            }
        %>
        <%@include file="includes/category.jsp" %>
        
        <div class="container-fluid">

                <div class="row">
                    <div class="col-lg-4"></div>
                </div>
                <br>
                <form method="post" action="addtocart">
                <div class="row row-cols-9">
                    <div class="col lg-5"></div>
                    <span>
                        <div class="col lg-1">
                            <input name="phone" type="checkbox" value="IPhone 13 Pro max"/>IPhone 13 Pro max
                        </div>
                        <div class="col lg-1">
                            <input name="phone" type="checkbox" value="Iphone 12"/>Iphone 12
                        </div><br/>
                       
                       <input type="submit" value="Add To Cart"/>
                      
                    </span>
                    <div class="col lg-5"></div>
                </div>
        
                <br>
                <div class="row row-cols-3">
                    
                </div>
                 </form>
                
            </div>

        
        <%@include file="includes/foot.jsp" %>
    </body>
</html>
