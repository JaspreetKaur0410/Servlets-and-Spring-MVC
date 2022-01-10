<%-- 
    Document   : index
    Created on : 23-Oct-2021, 1:11:41 pm
    Author     : jaspr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>
       
        <div class="container">
            <div class="card w-50 mx-auto my-5">
            <div class="card-header text-center">LOGIN</div> 
            <div class="card-body">
                
            <%
                if(session.getAttribute("username") != null){
                    response.sendRedirect("index.jsp");
                }
                else if(session.getAttribute("username") == null){
            %>
            <form action="index" method="post">
                <div class="form-group">
                    <label>Email</label>
                    <input class="form-control" type="email" placeholder="Enter Email"  name="l_email" required/>
                </div>
                
                <div class="form-group">
                    <label>Password</label>
                    <input class="form-control" type="password" placeholder="Enter Password"  name="l_password" required/>
                </div>
                <div class="text-center">
                    <input type="submit" value="Login" class="btn btn-primary"/>
                </div>
                
            </form>
            </div>
            </div>
        </div>
        <% } %>
        
        
        <%@include file="includes/foot.jsp" %>
    </body>
</html>
