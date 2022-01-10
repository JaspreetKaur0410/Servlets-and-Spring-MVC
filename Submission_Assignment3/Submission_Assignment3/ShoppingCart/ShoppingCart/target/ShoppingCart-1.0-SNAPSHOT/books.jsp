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
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <title>Cart Page</title>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>
        <h4>Books PAGE</h4>
        <%
            if (session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
            }
        %>
        <%@include file="includes/category.jsp" %>


        <!DOCTYPE html>
    <html lang="en">
        <head>
            <title>Bootstrap Example</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        </head>
        <body>

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
                            <input name="book" type="checkbox" value="Who will cry when you die"/>Who will cry when you die
                        </div>
                        <div class="col lg-1">
                            <input name="book" type="checkbox" value="Big Magic"/>Big Magic
                        </div><br/>
                        <input type="hidden" value=${link} name="link"/>
                        <h1>${link}</h1>
                        <input type="submit" value="Add To Cart"/>
                        
                    </span>
                    <div class="col lg-5"></div>
                </div>
                
                <br>
                <div class="row row-cols-3">
                    
                </div>
                </form>
            </div>
                        

        </body>
    </html>


    <%@include file="includes/foot.jsp" %>
</body>
</html>
