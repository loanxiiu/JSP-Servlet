package controller;

import DAO.AccountDAO;
import DAO.CityDAO;
import DAO.CustomerDAO;
import DAO.RoleDAO;
import model.Account;
import model.City;
import model.Customer;
import model.Role;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import util.Email;
import util.MaHoaMK;
import util.SoNgauNhien;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        }else if (hanhDong.equals("xac-thuc")) {
            xacThuc(request, response);
        }else if (hanhDong.equals("thay-doi-anh")) {
            thayDoiAnh(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().append("Served at: ").append(request.getContextPath());
        doGet(request, response);
    }

    protected void thayDoiAnh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object obj = request.getSession().getAttribute("customer");
        Optional<Customer> customer = Optional.empty();
        String url = "";
        String baoLoi = "";
        if (obj != null)
            customer = Optional.of((Customer) obj);
        if (customer.isPresent()) {
            try {
                String folder = getServletContext().getRealPath("avatar");
                System.out.println(folder);
                File file;
                int maxFileSize = 5000 * 1024;
                int maxMemSize = 5000 * 1024;

                String contentType = request.getContentType();

                if (contentType.indexOf(contentType) >= 0) {
                    DiskFileItemFactory factory = new DiskFileItemFactory();

                    // Quy dinh dung luong toi da cho 1 file
                    factory.setSizeThreshold(maxMemSize);

                    // Tao file upload
                    ServletFileUpload upload = new ServletFileUpload(factory);

                    upload.setSizeMax(maxFileSize);

                    List<FileItem> files = upload.parseRequest(request);

                    for (FileItem fileItem : files) {
                        if(!fileItem.isFormField()) {
                            String fileName = System.currentTimeMillis() + fileItem.getName();
                            String path = folder + "\\" + fileName;
                            file = new File(path);

                            fileItem.write(file);

                            customer.get().setDuongDanAnh(fileName);
                            CustomerDAO customerDAO = new CustomerDAO();
                            customerDAO.update(customer.orElse(null));
                            customer = customerDAO.selectById(customer.orElse(null));
                            baoLoi ="upload thành công";
                            url = "/customer/avatar.jsp";
                        }else {
                            String name = fileItem.getFieldName();
                            String value = fileItem.getString();
                            System.out.println(name+" : "+value);
                            baoLoi ="upload không thành công";
                            url = "/customer/avatar.jsp";
                        }
                    }
                }
                request.setAttribute("baoLoi", baoLoi);

                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
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

                if(customerDAO.insert(customer)){
                    String soNgauNhien = SoNgauNhien.getSoNgauNhien();
                    Date todaysDate = new Date(new java.util.Date().getTime());
                    Calendar c = Calendar.getInstance();
                    c.setTime(todaysDate);
                    c.add(Calendar.DATE, 1);
                    Instant thoiGianHietLucXacThuc = Instant.ofEpochMilli(c.getTimeInMillis());

//                    trang thai xac thuc = false;
                    boolean trangThaiXacThuc = false;

                    customer.setMaXacThuc(soNgauNhien);
                    customer.setThoiGianHieuLucCuaMaXacThuc(thoiGianHietLucXacThuc);
                    customer.setTrangThaiXacThuc(trangThaiXacThuc);

                    if(customerDAO.update(customer)){
                        Email.sendEmail(customer.getEmail(),"Xác thực tài khoản Coffee by Loan", getNoiDung(customer));
                    }
                }

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

    public static String getNoiDung(Customer customer){
        String link ="http://localhost:8080/JSP_Coffee2_war_exploded/CustomerController?hanhDong=xac-thuc&idCustomer="+customer.getIdCustomer()+"&maXacThuc="+customer.getMaXacThuc();
        String noiDung = "<p>Coffee by Loan xin ch&agrave;o bạn&nbsp;<strong>"+customer.getNameCustomer()+"</strong></p>\n" +
                "<p>vui l&ograve;ng x&aacute;c thực t&agrave;i khoản của bạn bằng c&aacute;ch nhập m&atilde; <strong>"+customer.getMaXacThuc()+"</strong>, hoặc click trực tiếp v&agrave;o đường dẫn sau:</p>\n" +
                "<p><a href=\""+link+"\">"+link+"</a></p>\n" +
                "<p>Đ&acirc;y l&agrave; email tự động vui l&ograve;ng kh&ocirc;ng phản hồi</p>\n" +
                "<p>Cảm ơn bạn</p>";
        return noiDung;
    }

    private void xacThuc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCustomer = request.getParameter("idCustomer");
        String maXacThuc = request.getParameter("maXacThuc");

        CustomerDAO customerDAO = new CustomerDAO();
        Customer cu = new Customer();
        cu.setIdCustomer(idCustomer);
        Optional<Customer> customer = customerDAO.selectById(cu);

        String msg = "";
        if(customer!=null){
            if(customer.get().getMaXacThuc().equals(maXacThuc)){
                customer.get().setTrangThaiXacThuc(true);
                customerDAO.update(customer.get());
                msg = "Xác thực thành công";
            }else {
                msg = "Xác thực không thành công!";
            }
            String url = "/customer/thongbao.jsp";
            request.setAttribute("baoLoi", msg);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
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