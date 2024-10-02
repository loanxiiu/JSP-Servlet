<%--
  Created by IntelliJ IDEA.
  User: ploan
  Date: 23/09/2024
  Time: 7:56 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

    </head>
</head>
<body class="d-flex align-items-center py-4 bg-body-tertiary">
<%
    String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<link rel="stylesheet" href="<%=url%>/css/signin.css">
    <main class="form-signin w-100 m-auto">
        <form class="text-center" action="do-login" method="post">
            <img class="mb-4" src="img/coffee.png" alt="" width="72" height="57">
            <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
            <%
                String baoLoi = request.getAttribute("baoLoi")+"";
                if(baoLoi.equals("null")){
                    baoLoi="";
                }
            %>
            <div style="color: red"><%=baoLoi%></div>

            <div class="form-floating">
                <input type="text" class="form-control" id="username" name="username" placeholder="name@example.com">
                <label for="username">Email address</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password">
                <label for="floatingPassword">Password</label>
            </div>

            <div class="form-check text-start my-3">
                <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
                <label class="form-check-label" for="flexCheckDefault">
                    Remember me
                </label>
            </div>
            <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>
            <a href="register.jsp">Đăng ký tài khoản mới</a>
            <p class="mt-5 mb-3 text-body-secondary">© Coffee made by Loan xinh iu</p>
        </form>
    </main>
</body>
</html>
