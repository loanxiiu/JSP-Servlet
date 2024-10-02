<%--
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
</head>
<body>
<%
    String baoLoi = request.getAttribute("baoLoi")+"";
    baoLoi = baoLoi.equals("null")?"":baoLoi;

    String hoVaTen = request.getAttribute("hoVaTen")+"";
    hoVaTen = hoVaTen.equals("null")?"":hoVaTen;

    String gioiTinh = request.getAttribute("gioiTinh")+"";
    gioiTinh = gioiTinh.equals("null")?"":gioiTinh;

    String ngaySinh = request.getAttribute("ngaySinh")+"";
    ngaySinh = ngaySinh.equals("null")?"":ngaySinh;

    String diaChi = request.getAttribute("diaChi")+"";
    diaChi = diaChi.equals("null")?"":diaChi;

    String soDienThoai = request.getAttribute("soDienThoai")+"";
    soDienThoai = soDienThoai.equals("null")?"":soDienThoai;

    String email = request.getAttribute("email")+"";
    email = email.equals("null")?"":email;

    String tenDangNhap = request.getAttribute("tenDangNhap")+"";
    tenDangNhap = tenDangNhap.equals("null")?"":tenDangNhap;

    String dongYDieuKhoan = request.getAttribute("dongYDieuKhoan")+"";
    dongYDieuKhoan = dongYDieuKhoan.equals("null")?"":dongYDieuKhoan;

    String dongYNhanMail = request.getAttribute("dongYNhanMail")+"";
    dongYNhanMail = dongYNhanMail.equals("null")?"":dongYNhanMail;

%>

<div class="container">
    <div class="text-center"><h1>Đăng ký</h1></div>
    <div id="baoLoi" style="color: red; white-space: nowrap">
        <%=baoLoi%>
    </div>

    <form class="form" action="do-register" method="post">
        <div class="row">
            <div class="col-md-6">
                <h3>Thông tin khách hàng</h3>
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
            </div>

            <div class="col-md-6">
                <h3>Tài khoản</h3>
                <div class="mb-3">
                    <label for="tenDangNhap" class="form-label">Tên đăng nhập</label><span style="color:red">*</span>
                    <input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap" required="required" value="<%=tenDangNhap%>">
                </div>
                <div class="mb-3">
                    <label for="matKhau" class="form-label">Mật khẩu</label><span style="color:red">*</span>
                    <input type="password" class="form-control" id="matKhau" name="matKhau" required="required" onkeyup="kiemTraMK()">
                </div>
                <div class="mb-3">
                    <label for="nhapLaiMK" class="form-label">Nhập lại mật khẩu</label><span id="msg" style="color:red">*</span>
                    <input type="password" class="form-control" id="nhapLaiMK" name="nhapLaiMK" required="required" onkeyup="kiemTraMK()">
                </div>
                <div class="mb-3">
                    <input type="checkbox" id="dongYDieuKhoan" name="dongYDieuKhoan" onchange="xuLyChonDongY()" placeholder="nguyenduyloi@gmail.com" required="required" value="dongYDieuKhoan" <%=dongYDieuKhoan.equals("dongYDieuKhoan")?"checked":""%>>
                    <label for="dongYDieuKhoan" class="form-label">Đồng ý với <a href="">Điều khoản của công ty </a></label><span style="color:red">*</span>
                </div>
                <div class="mb-3">
                    <input type="checkbox" id="dongYNhanMail" name="dongYNhanMail" placeholder="nguyenduyloi@gmail.com" value="dongYNhanMail" <%=dongYNhanMail.equals("dongYNhanMail")?"checked":""%>>
                    <label for="dongYNhanMail" class="form-label">Đồng ý nhận email </label>
                </div>
                <input class="btn btn-primary form-control" type="submit" value="Đăng ký" name="submit" id="submit" style="visibility: hidden">
            </div>
        </div>

    </form>
</div>
</body>
<script>
    function kiemTraMK(){
        matKhau = document.getElementById("matKhau").value
        matkhaunhaplai = document.getElementById("nhapLaiMK").value
        if(matKhau != matkhaunhaplai){
            document.getElementById("msg").innerHTML = "Mật khẩu không khớp"
            return false;
        }
        else {
            document.getElementById("msg").innerHTML = ""
            return true
        }
    }

    function xuLyChonDongY(){
        dongYDieuKhoan = document.getElementById("dongYDieuKhoan");
        if(dongYDieuKhoan.checked == true){
            document.getElementById("submit").style.visibility = "visible"
        }
        else {
            document.getElementById("submit").style.visibility="hidden"
        }
    }
    window.onload = function() {
        // Call the function once when the page loads to set the correct state
        xuLyChonDongY();
    };
</script>
</html>
