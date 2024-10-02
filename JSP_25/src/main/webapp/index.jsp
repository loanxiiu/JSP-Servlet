<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%
    String username = (String) session.getAttribute("username");
%>
<%
    if(username != null){%>
<jsp:forward page="success.jsp"></jsp:forward>
<%
    }
%>
<form action="Login" method="get">
    <table>
        <tr>
            <td colspan="2">Login</td>
        </tr>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="login">
            </td>
        </tr>
    </table>
</form>
</body>
</html>