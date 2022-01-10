 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
            
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                   
                    <%
                        if(session.getAttribute("username") != null){
                     %>
                    <li class="nav-item">
                        <a class="nav-link" href="list.jsp">Cart</a>
                    </li>
                   
                    <li class="nav-item">
                        <a class="nav-link" href="logout.jsp">Logout</a>
                    </li>
                    <% } %>
                    
                     <%
                        if(session.getAttribute("username") == null){
                     %>                 
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login</a>
                    </li>
                    <% } %>
                </ul>
                    
            </div>
        </nav>
                    <h6> ${sessionScope.username} </h6>