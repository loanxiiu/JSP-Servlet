<%@ page import="model.Customer" %>
<%@ page import="java.sql.Date" %>
<%@ page import="model.City" %><%--
  Created by IntelliJ IDEA.
  User: ploan
  Date: 21/09/2024
  Time: 11:15 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <%
        String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    %>
</head>
<body>
<%
    Object obj = session.getAttribute("customer");
    Customer customer = null;
    if (obj != null) {
        customer = (Customer)obj;
    }
    if (customer == null) {
%>
<h1>Bạn chưa đăng nhập vào hệ thống</h1>
<%
    } else{
%>
<div class="container">
    <%
        String baoLoi = request.getAttribute("baoLoi")+"";
        baoLoi = (baoLoi.equals("null"))?"":baoLoi;

        String hoVaTen = customer.getNameCustomer();
        String gioiTinh = "";
        if(customer.isGender()){
            gioiTinh = "Male";
        }else {
            gioiTinh = "Female";
        }
        Date ngaySinh = customer.getDateOfBirth();
        String diaChi = customer.getAddress().getNameCity();
        String soDienThoai = customer.getPhoneNumber();
        String email = customer.getEmail();
    %>
    <div class="text-center"><h1>Thay đổi thông tin khách hàng</h1></div>
    <div id="baoLoi" style="color: red; white-space: nowrap">
        <%=baoLoi%>
    </div>

    <form class="form" action="<%=url%>/CustomerController" method="post">
        <input type="hidden" name="hanhDong" value="do-changeInfo">
        <div class="mb-3">
            <label for="hoVaTen" class="form-label">Họ và tên</label><span style="color:red">*</span>
            <input type="text" class="form-control" id="hoVaTen" name="hoVaTen" placeholder="Nguyen Duy Loi" required="required" value="<%=hoVaTen%>">
        </div>
        <label class="form-label">Giới tính</label>
        <div class="mb-3">
            <input type="radio" id="idgioiTinhM" name="gioiTinh" value="Male" <%=gioiTinh.equals("Male")?"checked" : ""%>>
            <label for="idgioiTinhM" class="form-label">Nam</label>
            <input type="radio" id="idgioiTinhF" name="gioiTinh" value="Female" <%=gioiTinh.equals("Female")?"checked" : ""%>>
            <label for="idgioiTinhF" class="form-label">Nữ</label>
        </div>
        <div class="mb-3">
            <label for="ngaySinh" class="form-label">Ngày sinh</label>
            <input type="date" class="form-control" id="ngaySinh" name="ngaySinh" value="<%=ngaySinh%>">
        </div>
        <div class="mb-3">
            <label for="diaChi" class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" id="diaChi" name="diaChi" placeholder="Định Công, Hoàng Mai, Hà Nội" value="<%=diaChi%>">
        </div>
        <div class="mb-3">
            <label for="soDienThoai" class="form-label">Số điện thoại</label>
            <input type="text" class="form-control" id="soDienThoai" name="soDienThoai" placeholder="0347124532" value="<%=soDienThoai%>">
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label><span style="color:red">*</span>
            <input type="email" class="form-control" id="email" name="email" placeholder="nguyenduyloi@gmail.com" required="required" value="<%=email%>">
        </div>
        <input class="btn btn-primary form-control" type="submit" value="Lưu thông tin" name="submit" id="submit">
    </form>
</div>
<%
    }
%>
</body>
</html>
