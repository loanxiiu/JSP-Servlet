package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SaveProduct", value = "/SaveProduct")
public class SaveProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String maSanPham = request.getParameter("maSanPham");
        String tenSanPham = request.getParameter("tenSanPham");
        String giaBan = request.getParameter("giaBan");
        String giaNhap = request.getParameter("giaNhap");
        String hanSuDung = request.getParameter("hanSuDung");
        String vat = request.getParameter("vat");
        String moTa = request.getParameter("moTa");

//        check
        String e_maSanPham = "";
        if(maSanPham == null || maSanPham.trim().length() == 0){
            e_maSanPham = "Vui lòng nhập mã sản phẩm";
//            request.setAttribute("",moTa);
        } else if (maSanPham.equals("123")) {
            e_maSanPham += "Mã sản phẩm 123 đã tồn tại, vui lòng nhập lại MSP!";
        }
        request.setAttribute("e_maSanPham", e_maSanPham);


//        forward value
        request.setAttribute("value_maSanPham", maSanPham);
        request.setAttribute("value_tenSanPham", tenSanPham);
        request.setAttribute("value_giaBan", giaBan);
        request.setAttribute("value_giaNhap", giaNhap);
        request.setAttribute("value_vat", vat);
        request.setAttribute("value_hanSuDung", hanSuDung);
        request.setAttribute("value_moTa", moTa);

//        url
        String url = "/success.jsp";
        if(e_maSanPham.length()>0){
            url="/index.jsp";
        }
        RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
        rq.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}