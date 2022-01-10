<%-- 
    Document   : jstl
    Created on : 16-Oct-2021, 11:13:47 pm
    Author     : jaspr
--%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL JSP Page</title>
    </head>
    <body>
        <h3 color='red'> <u>CORE TAGS</u> </h3>
                <c:out value="<c:out> Tag" />
                <c:out value="${requestScope.id}" default="None"/>

        <h4> FOR EACH </h4>
        <c:forEach var="i" begin="1" end="10" step="2">
            i=${i}
        </c:forEach>

        <c:forEach var="item" items="${list}">
            ${item}
        </c:forEach>

        <h4> FOR TOKENS </h4>
        <c:forTokens var="item" items="<Once)upon,A(Timehfkf dfsbs%There..." delims="<),(%>">
            ${item}
        </c:forTokens>

        <h4> C:IF </h4>
        <c:forEach var="i" begin="1" end="10" step="1">
            i=${i} <c:if test="${i%2==0}"> (EVEN) </c:if>
        </c:forEach>

        <h4> C:CHOOSE </h4>
        <c:forEach var="i" begin="1" end="10" step="1">
        <LI> i=${i}
            <c:choose>
                <c:when test="${i<3}">(LESS THAN 3)</c:when>
                <c:when test="${i<6}">(LESS THAN 6)</c:when>
                <c:otherwise> (GREATER THAN 6) </c:otherwise>
            </c:choose>
        </li>
    </c:forEach><br/>


    <h3 color='red'><u> FORMATTING TAGS</u> </h3>
            <c:set var  ="num" value="65724.8273" />
    <h4 color="red">NUMBER AFTER SETTING TYPE="CURRENCY"</h4>
    <fmt:formatNumber value="${num}" type="currency" ></fmt:formatNumber>

        <h4 color="red">NUMBER AFTER SETTING PATTERN</u></h4>
        <fmt:formatNumber type="number" pattern="###,###.##" value="${num}"></fmt:formatNumber>

    <h4 color="red">Number after parsing by setting "integerOnly" attribute to true: </h4>
<fmt:parseNumber  var="num" value="${num}" integerOnly="true"></fmt:parseNumber> 
<c:out value="${num}"/>

<c:set var="currentDate" value="2021-10-21" />
<fmt:parseDate value="${currentDate}" var="parsedDate" pattern="yyyy-MM-dd" />
<h4>Current date after parsing: </h4>
<c:out value="${parsedDate}"/>

<!-- --------------------------------------------------------------- !-->

<h3 color='red'><u> SQL TAGS</u> </h3>
        <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
                           url = "jdbc:mysql://localhost/ecosystem"
                           user = "root"  password = ""/>
        <sql:query dataSource="${snapshot}" var="rs">select * from customers;</sql:query>
    <h4 color='red'>FETCH DATA FROM DATABASE</u></h4>
<table border='2'>
    <TR><TH>CustomerID</th>
        <TH>Name</th>
        <TH>Email</th>
        <TH>Location</th>
    </tr>
<c:forEach items="${rs.rows}" var="row">
    <tr>
        <td><c:out value="${row.CustomerID}"></c:out></td>
        <td><c:out value="${row.FullName}"></c:out></td>
        <td><c:out value="${row.Email}"></c:out></td>
        <td><c:out value="${row.Location}"></c:out></td>
        </tr>
</c:forEach>
</table>

<sql:setDataSource var = "snapshot2" driver = "com.mysql.jdbc.Driver"
                           url = "jdbc:mysql://localhost/ecosystem"
                           user = "root"  password = ""/>
        <sql:query dataSource="${snapshot2}" var="rs">select * from customers;</sql:query>
            
<h4 color="red">UPDATE CUSTOMER 5</h4>
<sql:update dataSource="${snapshot}" var="query2">
    UPDATE customers SET Email=? where CustomerID=5
<sql:param value="a@gmail.com" />
</sql:update>
<sql:query dataSource="${snapshot}" var="query">
        SELECT * from customers;
    </sql:query>
    <table border='2'>
    <TR><TH>CustomerID</th>
        <TH>Name</th>
        <TH>Email</th>
        <TH>Location</th>
    </tr>
<c:forEach items="${query.rows}" var="row">
    <tr>
        <td><c:out value="${row.CustomerID}"></c:out></td>
        <td><c:out value="${row.FullName}"></c:out></td>
        <td><c:out value="${row.Email}"></c:out></td>
        <td><c:out value="${row.Location}"></c:out></td>
        </tr>
</c:forEach>
</table>
        
<!-- --------------------------------------------------------------- !-->

<h3 color='red'><u> XML TAGS</u> </h3>  
<h4>X:OUT TAG</h4>
<c:set var="colleges">  
<colleges>  
    <college>  
      <name>IIT</name>  
      <fees>10000</fees>  
    </college>  
 <college>  
      <name>NIT</name>  
      <fees>3400000</fees>  
    </college>  
 <college>  
      <name>Others</name>  
      <fees>3438899</fees>  
    </college>  
</colleges>  
</c:set>  
<x:parse xml="${colleges}" var="output"/>  
<b>Name of the college is</b>:  
<x:out select="$output/colleges/college[1]/name" /><br>  
<b>fees of the college is</b>:  
<x:out select="$output/colleges/college[2]/fees" />  


<h4>X:PARSE TAG</h4>

<c:import var="bookInfo" url="novels.xml"/>  
 
<x:parse xml="${bookInfo}" var="output"/>  
<p>First Book title: <x:out select="$output/books/book[1]/name" /></p>  
<p>First Book price: <x:out select="$output/books/book[1]/price" /></p>  
<p>Second Book title: <x:out select="$output/books/book[2]/name" /></p>  
<p>Second Book price: <x:out select="$output/books/book[2]/price" /></p>  

<h4>X:PARSE SET</h4>
<x:set var="fragment" select="$output/books/book[2]/price"/>  
<b>The price of the Tomorrow land book</b>:  
<x:out select="$fragment" />  

<!-- ____________________________________________________________ !-->

<h3 color='red'><u> FUNCTION TAGS</u> </h3> 

<h4>fn:contains TAG</h4>
<c:set var="String" value="Northeastern University"/>
<c:if test="${fn:contains(String, 'University')}">  
   <p>Found University string<p>  
</c:if>  
       
<h4>fn:containsIgnoreCase()</h4>
<c:if test="${fn:containsIgnoreCase(String, 'University')}">  
   <p>Found University string<p>  
</c:if>  
<c:if test="${fn:containsIgnoreCase(String, 'UNIVERSITY')}">  
   <p>Found UNIVERSITY string<p>  
</c:if>  
       
<h4>fn:IndexOf()</h4>
<p>Index of "Northeastern" : ${fn:indexOf(String, "Northeastern")}</p>  
</body>
</html>
