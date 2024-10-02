<%--
  Created by IntelliJ IDEA.
  User: ploan
  Date: 9/8/2024
  Time: 7:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Dat Hang</title>
</head>
<body>
<%
    String hoVaTen = request.getParameter("hoVaTen");
    String email = request.getParameter("email");
    String soLuong = request.getParameter("soLuong");
    int soLuongSanPham =1;
    try{
        soLuongSanPham = Integer.parseInt(soLuong);
    }catch (Exception e){
        e.printStackTrace();
    }
%>
<h1>Xác nhận đặt hàng</h1>
<p>Xin cảm ơn bạn <b> <%=hoVaTen%> </b> đã đặt <b> <%=soLuong%> </b> sản phẩm. <br>
    Số tiền cần thanh toán là <b> <%=soLuongSanPham*5%>$</b>.
    Bạn sẽ nhận được thông báo qua email: <b> <%=email%> </b></p>
</body>
</html>
