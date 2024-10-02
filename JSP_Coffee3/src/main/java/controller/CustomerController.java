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
import java.util.List;
import java.util.Optional;
import java.util.Random;

@WebServlet(name="CustomerController", value = "/CustomerController")
public class CustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public CustomerController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hanhDong = request.getParameter("hanhDong");
        if(hanhDong.equals("do-login")){
            Login(request, response);
        }else if(hanhDong.equals("do-logout")){
            Logout(request, response);
        }else if(hanhDong.equals("do-register")){
            Register(request, response);
        }else if(hanhDong.equals("do-changePassword")){
            ChangePasswored(request, response);
        }else if(hanhDong.equals("do-changeInfo")){
            ChangeInfo(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void Login(HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            password = MaHoaMK.toSHA1(password);

            String url = "";
            AccountDAO accountDAO = new AccountDAO();
            CustomerDAO customerDAO = new CustomerDAO();
            List<Account> accountList= accountDAO.selectByCondition("username='"+username+"' and password='"+password+"'");
            Account account = accountList.size()!=0?accountList.get(0):null;
            if(account != null){
                List<Customer> customerList = customerDAO.selectByCondition("username='"+username+"'");
                Customer customer = customerList.size()!=0?customerList.get(0):null;
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("customer", customer);
                url = "/index.jsp";
            }
            else {
                request.setAttribute("baoLoi", "Tên đăng nhập hoặc mật khẩu không đúng");
                url = "/customer/login.jsp";
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);

        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void Logout(HttpServletRequest request, HttpServletResponse response)  {
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            response.sendRedirect(url+"/index.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void Register(HttpServletRequest request, HttpServletResponse response)  {
        try {
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
                url = "/customer/register.jsp";
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
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void ChangeInfo(HttpServletRequest request, HttpServletResponse response)  {
        try {
            String hoVaTen = request.getParameter("hoVaTen");
            String gioiTinh = request.getParameter("gioiTinh");
            String ngaySinh = request.getParameter("ngaySinh");
            String diaChi = request.getParameter("diaChi");
            String soDienThoai = request.getParameter("soDienThoai");
            String email = request.getParameter("email");

            request.setAttribute("hoVaTen", hoVaTen);
            request.setAttribute("gioiTinh", gioiTinh);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("soDienThoai", soDienThoai);
            request.setAttribute("email", email);

            String url = "";
            String baoLoi = "";
            CustomerDAO customerDAO = new CustomerDAO();
            request.setAttribute("baoLoi", baoLoi);
            if(baoLoi.length()>0){
                url = "/customer/register.jsp";
            }else {
                Object obj = request.getSession().getAttribute("customer");
                Customer customer = (Customer)obj;
                if(obj!=null){
                    customer = (Customer)obj;
                }
                if(customer!=null){
                    boolean gtinh = false;
                    if(gioiTinh.equals("Male")){
                        gtinh = true;
                    }
                    CityDAO cityDAO = new CityDAO();
                    City city = cityDAO.selectByCondition("nameCity LIKE '%"+diaChi+"%'").isEmpty()?null:cityDAO.selectByCondition("nameCity LIKE '%"+diaChi+"%'").get(0);
                    String maKhachHang = customer.getIdCustomer();
                    Customer customer1 = new Customer(maKhachHang, hoVaTen, Date.valueOf(ngaySinh), gtinh, city ,soDienThoai,email,customer.getAccount());
                    customerDAO.update(customer1);
                    request.getSession().setAttribute("customer", customer1);
                    url = "/customer/success.jsp";
                }
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void ChangePasswored(HttpServletRequest request, HttpServletResponse response)  {
        try {
            String matKhauHienTai = request.getParameter("matKhauHienTai");
            String matkhauMoi = request.getParameter("matKhauMoi");
            String matKhauNhapLai = request.getParameter("matKhauNhapLai");

            String matKhauHienTaiSHA1 = MaHoaMK.toSHA1(matKhauHienTai);
            String baoLoi = "";
            String url = "/customer/ChangePassword.jsp";
//        String url = ""; thay doi mat khau sau 5s quay lai trang chu
            HttpSession session = request.getSession();
            Object obj = session.getAttribute("customer");
            Customer customer = null;
            if(obj != null){
                customer =(Customer) obj;
            }
            if(customer==null){
                baoLoi="Bạn chưa đăng nhập vào hệ thống";
    //            url = "/customer/ChangePassword.jsp";
            }else {
                if(!matKhauHienTaiSHA1.equals(customer.getAccount().getPassword())){
                    baoLoi = "Mật khẩu hiện hiện tại không chính xác";
    //                url = "/customer/ChangePassword.jsp";

                }else{
                    if(!matKhauNhapLai.equals(matkhauMoi)){
                        baoLoi = "Nhập lại mật khẩu không khớp";
    //                    url = "/customer/ChangePassword.jsp";
                    }else{
                        String matKhauMoiSHA1 = MaHoaMK.toSHA1(matkhauMoi);
                        AccountDAO accountDAO = new AccountDAO();
                        Account account = new Account();
                        account.setUsername(customer.getAccount().getUsername());
                        account.setPassword(matKhauMoiSHA1);
                        account.setRole(customer.getAccount().getRole());
                        if(accountDAO.update(account)){
                            baoLoi = "Mật khẩu đã thay đổi thành công";
    //                        url = "index.jsp";
                        }else{
                            baoLoi = "Thay đổi mật khẩu không thành công";
    //                        url = "/customer/ChangePassword.jsp";
                        }
                    }
                }
            }
            request.setAttribute("baoLoi", baoLoi);

            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    protected void logout(HttpServletRequest request, HttpServletResponse response)  {
//
//    }
}