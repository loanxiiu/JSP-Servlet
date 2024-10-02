package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "MuaHang", value = "/MuaHang")
public class MuaHang extends HttpServlet {
    public MuaHang(){}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String soLuong = request.getParameter("soLuong");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");

        boolean checkError = false;
        double giatri_soLuong =0;
        // bat loi so luong
        try{
            giatri_soLuong = Double.parseDouble(soLuong);
        } catch (Exception e){
            checkError = true;
            request.setAttribute("e_soLuong", "Nhập dữ liệu số lượng không đúng!");
        }

        // bat loi so luong phai lon hon 0
        if(giatri_soLuong ==0){
            checkError = true;
            request.setAttribute("e_soLuong", "Vui lòng chọn số lượng mua lớn hơn 0!");
        }

        // kiem tra so dien thoai
        Pattern sodienThoaiPattern = Pattern.compile("\\d{10}");
        Matcher soDienThoaiMatcher = sodienThoaiPattern.matcher(soDienThoai);
        if(!soDienThoaiMatcher.matches()){
            checkError = true;
            request.setAttribute("e_soDienThoai", "Số điện thoại bao gồm 10 ký tự!");
        }

        // kiem tra email
        Pattern emailPattern = Pattern.compile("\\w+@\\w+(\\.\\w+)+(\\.\\w+)*");
        Matcher emailMatcher = emailPattern.matcher(email);
        if(!emailMatcher.matches()){
            checkError = true;
            request.setAttribute("e_email", "Cấu trúc Email chưa đúng!");
        }


        String url = "/success.jsp";
        if(checkError){
            url="/index.jsp";
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}