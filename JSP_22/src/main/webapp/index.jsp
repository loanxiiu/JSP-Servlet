<%--
  Created by IntelliJ IDEA.
  User: ploan
  Date: 9/9/2024
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</head>
<body>

<%
    String e_maSanPham = request.getAttribute("e_maSanPham")+"";
    e_maSanPham= (e_maSanPham.equals("null"))?"":e_maSanPham;

    String value_maSanPham = request.getAttribute("value_maSanPham")+"";
    String value_tenSanPham = request.getAttribute("value_tenSanPham")+"";
    String value_giaBan = request.getAttribute("value_giaBan")+"";
    String value_giaNhap = request.getAttribute("value_giaNhap")+"";
    String value_hanSuDung = request.getAttribute("value_hanSuDung")+"";
    String value_vat = request.getAttribute("value_vat")+"";
    String value_moTa = request.getAttribute("value_moTa")+"";

    value_maSanPham = (value_maSanPham.equals("null"))?"":value_maSanPham;
    value_tenSanPham = (value_tenSanPham.equals("null"))?"":value_tenSanPham;
    value_giaBan = (value_giaBan.equals("null"))?"":value_giaBan;
    value_giaNhap = (value_giaNhap.equals("null"))?"":value_giaNhap;
    value_vat = (value_vat.equals("null"))?"":value_vat;
    value_hanSuDung = (value_hanSuDung.equals("null"))?"":value_hanSuDung;
    value_moTa = (value_moTa.equals("null"))?"":value_moTa;
%>
<div class="container mt-4">
    <form class="row g-3 needs-validation" action="SaveProduct" id="my_form">
        <div class="row">
            <div class="col-6">
                <label for="maSanPham" class="form-label">Mã sản phẩm<span style="color: red">*</span> </label>
                <input type="text" class="form-control" id="maSanPham" name="maSanPham" value="<%=value_maSanPham%>" required>
                <div style="color: red"><%=e_maSanPham%></div>
            </div>
            <div class="col-6">
                <label for="tenSanPham" class="form-label">Tên sản phẩm<span style="color: red">*</span> </label>
                <input type="text" class="form-control" id="tenSanPham" name="tenSanPham" value="<%=value_tenSanPham%>" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-6">
                <label for="giaNhap" class="form-label">Giá nhập<span style="color: red">*</span> </label>
                <input type="text" step="0.01" class="form-control" id="giaNhap" name="giaNhap" value="<%=value_giaNhap%>" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
            <div class="col-6">
                <label for="giaBan" class="form-label">Giá bán<span style="color: red">*</span> </label>
                <input type="number" step="0.01" class="form-control" id="giaBan" name="giaBan" value="<%=value_giaBan%>" required>
                <div id="error_giaBan"></div>
            </div>
        </div>

        <div class="row">
            <div class="col-6">
                <label for="hanSuDung" class="form-label">Hạn sử dụng</label>
                <input type="date" class="form-control" id="hanSuDung" name="hanSuDung" value="<%=value_hanSuDung%>">
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
            <div class="col-6">
                <label for="vat" class="form-label">VAT</label>
                <input type="number" class="form-control" id="vat" name="vat" value="<%=value_vat%>">
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
        </div>

        <div class="row">
            <label for="moTa" class="form-label">Mô tả sản phẩm</label>
            <textarea name="moTa" id="moTa" cols="20" rows="10"><%=value_moTa%></textarea>
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>
        <div class="row">
            <button class="btn btn-primary" type="button" onclick="my_submit()">Lưu sản phẩm</button>
        </div>
    </form>
</div>

<script>
    function my_submit(){
        error = ""
        maSanpham = document.getElementById("maSanPham").value
        giaBan = document.getElementById("giaBan").value
        giaNhap = document.getElementById("giaNhap").value

        if(maSanpham.length == 0){
            error = "Bạn phải nhập mã sản phẩm"
            // alert(error)
        }
        if(giaBan<=0){
            error_giaBan = document.getElementById("error_giaBan")
            error_giaBan.innerHTML ="<span style='color: red'>Bạn cần nhập giá bán</span>"
        }
        if(error.length>0){
            return
        }
        else {
            my_form = document.getElementById("my_form")
            my_form.submit();
        }
    }
</script>
</body>
</html>
