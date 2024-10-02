<%@ page import="model.Customer" %><%--Navbar--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath();
%>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="http://localhost:8080/JSP_Coffee2_war_exploded/img/coffee.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
            Coffee
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Giảm giá</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Thể loại
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Losto</a></li>
                        <li><a class="dropdown-item" href="#">Capybara</a></li>
                        <li><a class="dropdown-item" href="#">Loopy</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Khác</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" aria-disabled="true">Hết hàng</a>
                </li>
            </ul>
            <form class="d-flex" role="search" style="width: 70%">
                <input class="form-control me-2" type="search" placeholder="Bạn muốn uống gì?" aria-label="Search">
                <button class="btn btn-outline-success" type="submit" style="width: 15%">Tìm kiếm</button>
                <%
                    Object obj = session.getAttribute("customer");
                    Customer customer = null;
                    if(obj != null) {
                        customer =  (Customer)obj;
                    }
                    if(customer == null) {
                %>
                <a href="<%=url%>/customer/login.jsp" class="btn btn-primary" style="white-space: nowrap">
                    Đăng nhập
                </a>
                <%
                }else {
                %>
                <ul class="navbar-nav me-auto mb-2 mb-lg-0 bg-infor ">
                    <li class="nav-item dropdown"><a
                            class="nav-link dropdown-toggle" href="#" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">Xin chào <%=customer.getNameCustomer()%></a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Đơn hàng của tôi</a></li>
                            <li><a class="dropdown-item" href="#">Thông báo</a></li>
                            <li><a class="dropdown-item" href="<%=url%>/customer/avatar.jsp">Thay đổi ảnh avatar</a></li>
                            <li><a class="dropdown-item" href="<%=url%>/customer/ChangeInfo.jsp">Thay đổi thông tin</a></li>
                            <li><a class="dropdown-item" href="<%=url%>/customer/ChangePassword.jsp">Đổi mật khẩu</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="<%=url%>/CustomerController?hanhDong=do-logout">Thoát tài khoản</a></li>
                        </ul></li>
                </ul>
                <%
                    }
                %>
            </form>
        </div>
    </div>
</nav>
<%--End Navbar--%>
