<ul class="nav list-inline justify-content-center" style="background: buttontext">
            <%
                if (session.getAttribute("username") != null) {
            %>
            <li class="nav-item">
                <a class="nav-link" href="books.jsp?link=books">Books</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="phones.jsp?link=phones">Phones</a>
            </li> 
            <li class="nav-item">
                <a class="nav-link" href="women.jsp?link=women">Women Dresses</a>
            </li>
            <% }%>  
        </ul>