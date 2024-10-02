<%--
  Created by IntelliJ IDEA.
  User: ploan
  Date: 9/10/2024
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username = (String)session.getAttribute("username");
%>
Xin chao: <%=username%> <br>
<hr/>
<h1>DAY LA TRANG CHAO MUNG</h1>
<a href="trang1.jsp">Trang 1</a>
</body>
</html>
