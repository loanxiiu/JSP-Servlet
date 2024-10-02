package controller;

import DAO.AccountDAO;
import DAO.CityDAO;
import DAO.CustomerDAO;
import DAO.RoleDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Account;
import model.City;
import model.Customer;
import model.Role;
import util.MaHoaMK;

import java.io.IOException;
import java.sql.Date;
import java.util.Optional;
import java.util.Random;

@WebServlet(name = "Register", value = "/do-register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenDangNhap = request.getParameter("tenDangNhap");
        String matKhau = request.getParameter("matKhau");
        String nhaplaiMK = request.getParameter("nhapLaiMK");
        String dongYDieuKhoan = request.getParameter("dongYDieuKhoan");
        String dongYNhanMail = request.getParameter("dongYNhanMail");
        String hoVaTen = request.getParameter("hoVaTen");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChi = request.getParameter("diaChi");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");

        request.setAttribute("tenDangNhap", tenDangNhap);
        request.setAttribute("matKhau", matKhau);
        request.setAttribute("nhaplaiMK", nhaplaiMK);
        request.setAttribute("dongYDieuKhoan", dongYDieuKhoan);
        request.setAttribute("dongYNhanMail", dongYNhanMail);
        request.setAttribute("hoVaTen", hoVaTen);
        request.setAttribute("gioiTinh", gioiTinh);
        request.setAttribute("ngaySinh", ngaySinh);
        request.setAttribute("diaChi", diaChi);
        request.setAttribute("soDienThoai", soDienThoai);
        request.setAttribute("email", email);

        String url = "";
        String baoLoi = "";
        AccountDAO accountDAO = new AccountDAO();
        if(!accountDAO.selectByCondition("username = '"+tenDangNhap+"'").isEmpty()){
            baoLoi+= "Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác.<br/>";
        }
        if(!matKhau.equals(nhaplaiMK)){
            baoLoi+="Mật khẩu không khớp.<br/>";
        }
        else {
            matKhau = MaHoaMK.toSHA1(matKhau);
        }
        request.setAttribute("baoLoi", baoLoi);

        if(baoLoi.length() > 0){
            url = "/register.jsp";
        }
        else {
            RoleDAO roleDAO = new RoleDAO();
            Role role = new Role();
            role.setIdRole("C");
            Optional<Role> role1 = roleDAO.selectById(role);
            Role role2 = role1.orElse(null);

            Account account = new Account(tenDangNhap, matKhau, role2);
            accountDAO.insert(account);

            CityDAO cityDAO = new CityDAO();
            City city = cityDAO.selectByCondition("nameCity LIKE '%"+diaChi+"%'").isEmpty()?null:cityDAO.selectByCondition("nameCity LIKE '%"+diaChi+"%'").get(0);

            boolean gtinh = false;
            if(gioiTinh.equals("Male")){
                gtinh = true;
            }

            Random rd = new Random();
            String maKhachHang = "K"+ System.currentTimeMillis() + rd.nextInt(1000);
            Customer customer = new Customer(maKhachHang, hoVaTen, Date.valueOf(ngaySinh), gtinh, city, soDienThoai, email, account);
            CustomerDAO customerDAO = new CustomerDAO();
            customerDAO.insert(customer);

            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            url = "/index.jsp";
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}