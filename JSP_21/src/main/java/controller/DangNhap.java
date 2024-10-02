package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "DangNhap", value = "/DangNhap")
public class DangNhap extends HttpServlet {
    public DangNhap(){}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Set character
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().append("Bạn đang đăng nhập vào phương thức doGet");
//        response.getWriter().append("Served at: ").append(request.getContextPath());

        String tenDangNhap = request.getParameter("tenDangNhap");
        String matKhau = request.getParameter("matKhau");

        if(tenDangNhap.equalsIgnoreCase("Loan") && matKhau.equalsIgnoreCase("123456")){
//            response.getWriter().append("Chúc mừng bạn đã đăng nhập thành công");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/success.jsp");
            rd.forward(request,response);
        }
        else{
//            response.getWriter().append("Đăng nhập thất bại");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            rd.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //        response.getWriter().append("Ban dang vao phuong thuc doPost");
        doGet(request,response);
    }
}