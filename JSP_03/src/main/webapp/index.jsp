<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="container">
  <form action="google.com">
    <h1>ĐĂNG KÝ THÀNH VIÊN</h1>
    <table>
      <tbody>
      <tr>
        <td colspan="2"><b>THÔNG TIN ĐĂNG NHẬP</b></td>
      </tr>
      <tr>
        <td>Email:</td>
        <td><input type="email" name="email" id="idEmail"></td>
      </tr>
      <tr>
        <td>Mật khẩu:</td>
        <td><input type="password" name="password" id="idPassword"></td>
      </tr>
      <tr>
        <td colspan="2"><strong>THÔNG TIN CÁ NHÂN</strong></td>
      </tr>
      <tr>
        <td>Họ và tên:</td>
        <td><input type="text" name="hoVaTen" id="idHoVaTen"></td>
      </tr>
      <tr>
        <td>Giới tính:</td>
        <td>
          <input type="radio" name="gioiTinh" id="idGioiTinhM" value="M">
          <label for="idGioiTinhM">Nam</label>
          <input type="radio" name="gioiTinh" id="idGioiTinhF" value="F">
          <label for="idGioiTinhF">Nữ</label>
        </td>
      </tr>
      <tr>
        <td>Ngày sinh:</td>
        <td><input type="date" name="ngayDinh" id="idNgaySinh"></td>
      </tr>
      <tr>
        <td>Số điện thoại:</td>
        <td><input type="tel" name="soDienThoai" id="idSoDienThoai"></td>
      </tr>
      <tr>
        <td>Số di động:</td>
        <td><input type="tel" name="soDiDong" id="idSoDiDong"></td>
      </tr>
      <tr>
        <td colspan="2"><strong>ĐỊA CHỈ</strong></td>
      </tr>
      <tr>
        <td>Quốc gia</td>
        <td>
          <select name="quocGia" id="idQuocGia">
            <option value="VN">Việt Nam</option>
            <option value="PL">Ba Lan</option>
            <option value="US">Hoa Kỳ</option>
          </select>
        </td>
      <tr>
        <td>Tỉnh thành</td>
        <td>
          <select name="tinhThanh" id="idTinhThanh">
            <option value="HN">Hà Nội</option>
            <option value="HCM">TP Hồ Chí Minh</option>
            <option value="US">Hoa Kỳ</option>
          </select>
        </td>
      </tr>
      <tr>
        <td>Quận Huyện</td>
        <td>
          <select name="quanHuyen" id="idQuanHuyen">
            <option value="BD">Ba Đình</option>
            <option value="HM">Hoaàng Mai</option>
            <option value="DD">Đống Đa</option>
          </select>
        </td>
      </tr>
      <tr>
        <td>Địa chỉ nhà</td>
        <td>
          <textarea rows="5" cols="" name="diaChi" id="idDiaChi"></textarea>
        </td>
      </tr>
      <tr>
        <td colspan="2"><strong>BỔ SUNG</strong></td>
      </tr>
      <tr>
        <td>Sở thích</td>
        <td>
          <input type="checkbox" name="soThich" id="idSoThichDocSach">
          <label for="idSoThichDocSach">Đọc sách</label>
          <input type="checkbox" name="xemPhim" id="idXemPhim">
          <label for="idXemPhim">Xem phim</label>
        </td>
      </tr>
      <tr>
        <td>Hình ảnh</td>
        <td>
          <input type="file" name="hinhAnh" id="idHinhAnh">
        </td>
      </tr>
      <tr>
        <td>Tuổi</td>
        <td>
          <input type="number" name="tuoi" id="idTuoi" min="0" max="100">
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="Đăng ký">
          <input type="reset" value="Làm mới">
        </td>
      </tr>
      </tbody>
    </table>
  </form>
</div>

</body>
</html>