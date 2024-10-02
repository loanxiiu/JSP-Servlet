<%--
  Created by IntelliJ IDEA.
  User: ploan
  Date: 9/8/2024
  Time: 7:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
%>
<%
    if(username.equals("ntloan21122004@gmail.com") && password.equals("123456")){
%>
<h1>Bạn đã đăng nhập thành công</h1>
<%
    } else {
%>
<h1>Không tìm thấy tài khoản</h1>
<%
    }
%>
</body>
</html>
