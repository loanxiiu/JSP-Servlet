package controller;

import DAO.AccountDAO;
import DAO.CityDAO;
import DAO.CustomerDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.City;
import model.Customer;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ChangeInfo", value = "/do-changeInfo")
public class ChangeInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            url = "/register.jsp";
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
                url = "/success.jsp";
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}