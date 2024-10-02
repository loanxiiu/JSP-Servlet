<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</head>
<body>
<div class="container mt-5">
    <%
        String e_soLuong = request.getAttribute("e_soLuong")+"";
        String e_soDienThoai = request.getAttribute("e_soDienThoai")+"";
        String e_email = request.getAttribute("e_email")+"";
        e_soLuong = (e_soLuong.equals("null")) ? "" : e_soLuong;
        e_soDienThoai = (e_soDienThoai.equals("null")) ? "" : e_soDienThoai;
        e_email = (e_email.equals("null")) ? "" : e_email;
    %>
    <form action="MuaHang" method="get">
        Số lượng cần mua: <input class="form-control" type="text" name="soLuong" required="required"/>
        <span style="color: red"><%=e_soLuong%></span><br/>
        Số điện thoại: <input class="form-control" type="text" name="soDienThoai" required="required"/>
        <span style="color: red"><%=e_soDienThoai%></span><br/>
        Email: <input class="form-control" type="text" name="email" required="required"/>
        <span style="color: red"><%=e_email%></span><br/>
        <input class="form-control" type="submit" value="Mua hàng"/>
    </form>
</div>
</body>
</html>