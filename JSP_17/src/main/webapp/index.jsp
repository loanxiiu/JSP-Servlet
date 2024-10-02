<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.lang.*"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<%
    int a=3;
    int b=2;
    int sum=a+b;
    double canbachai = Math.sqrt(sum);
%>
<br>
3 + 2 = <%=sum%>
<br>
Can bac hai cua <%=sum%> = <%=canbachai%>
</body>
</html>