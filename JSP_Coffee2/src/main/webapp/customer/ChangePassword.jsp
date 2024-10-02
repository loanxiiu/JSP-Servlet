<%@ page import="model.Customer" %><%--
  Created by IntelliJ IDEA.
  User: ploan
  Date: 23/09/2024
  Time: 4:42 CH
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
<body>
<%
    Object obj = session.getAttribute("customer");
    Customer customer = null;
    if (obj != null) {
        customer = (Customer) obj;
    }
        if(customer == null){
%>
            <h1>Bạn chưa đăng nhập vào hệ thống. Vui lòng quay lại trang chủ!</h1>
<%
        }else{
            String baoLoi = request.getAttribute("baoLoi")+"";
            if(baoLoi.equals("null")){
                baoLoi = "";
        }
%>
<div class="container">
    <h1 class="text-center">Đổi mật khẩu</h1>
    <span style="color: red"><%=baoLoi%></span>
    <form action="../CustomerController" method="post">
        <input type="hidden" name="hanhDong" value="do-changePassword">
        <div class="mb-3">
            <label for="matKhauHienTai" class="form-label">Mật khẩu hiện tại</label>
            <input type="password" class="form-control" id="matKhauHienTai" name="matKhauHienTai">
        </div>
        <div class="mb-3">
            <label for="matKhauMoi" class="form-label">Mật khẩu mới</label>
            <input type="password" class="form-control" id="matKhauMoi" name="matKhauMoi">
        </div>
        <div class="mb-3">
            <label for="matKhauNhapLai" class="form-label">Nhập lại mật khẩu</label>
            <input type="password" class="form-control" id="matKhauNhapLai" name="matKhauNhapLai">
        </div>
        <button type="submit" class="btn btn-primary">Lưu mật khẩu</button>
    </form>
</div>
<%
    }
%>
</body>
</html>