package controller;

import DAO.AccountDAO;
import DAO.CustomerDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Account;
import model.Customer;
import util.MaHoaMK;

import java.io.IOException;

@WebServlet(name = "ChangePassword", value = "/do-changePassword")
public class ChangePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matKhauHienTai = request.getParameter("matKhauHienTai");
        String matkhauMoi = request.getParameter("matKhauMoi");
        String matKhauNhapLai = request.getParameter("matKhauNhapLai");

        String matKhauHienTaiSHA1 = MaHoaMK.toSHA1(matKhauHienTai);
        String baoLoi = "";
        String url = "";
//        String url = "/ChangePassword.jsp"; thay doi mat khau sau 5s quay lai trang chu
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("customer");
        Customer customer = null;
        if(obj != null){
            customer =(Customer) obj;
        }
        if(customer==null){
            baoLoi="Bạn chưa đăng nhập vào hệ thống";
//            url = "/ChangePassword.jsp";
        }else {
            if(!matKhauHienTaiSHA1.equals(customer.getAccount().getPassword())){
                baoLoi = "Mật khẩu hiện hiện tại không chính xác";
//                url = "/ChangePassword.jsp";
                
            }else{
                if(!matKhauNhapLai.equals(matkhauMoi)){
                    baoLoi = "Nhập lại mật khẩu không khớp";
//                    url = "/ChangePassword.jsp";
                }else{
                    String matKhauMoiSHA1 = MaHoaMK.toSHA1(matkhauMoi);
                    AccountDAO accountDAO = new AccountDAO();
                    Account account = new Account();
                    account.setUsername(customer.getAccount().getUsername());
                    account.setPassword(matKhauMoiSHA1);
                    account.setRole(customer.getAccount().getRole());
                    if(accountDAO.update(account)){
                        baoLoi = "Mật khẩu đã thay đổi thành công";
//                        url = "/index.jsp";
                    }else{
                        baoLoi = "Thay đổi mật khẩu không thành công";
//                        url = "/ChangePassword.jsp";
                    }
                }
            }
        }
        request.setAttribute("baoLoi", baoLoi);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}