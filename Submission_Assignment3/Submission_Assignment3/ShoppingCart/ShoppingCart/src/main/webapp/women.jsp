<%-- 
    Document   : index
    Created on : 23-Oct-2021, 1:11:41 pm
    Author     : jaspr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cart Page</title>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>
        <h4>Women PAGE</h4>
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
                            <input name="women" type="checkbox" value="Floral Saree"/>Floral Saree
                        </div>
                        <div class="col lg-1">
                            <input name="women" type="checkbox" value="T-Shirt"/>T-Shirt
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
