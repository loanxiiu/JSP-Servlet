package view;

import DAO.AccountDAO;
import DAO.CityDAO;
import DAO.CustomerDAO;
import model.City;
import model.Customer;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        CityDAO cityDAO = new CityDAO();
        City city1 = new City("HN", "HaNoi",20000);
        City city2 = new City("BN", "Bac Ninh",30000);
        City city3 = new City("TH", "Thanh Hoa",50000);
        City city4 = new City("NB", "Ninh Binh", 40000);
        City city5 = new City("HP", "Hai Phong", 40000);
        City city6 = new City("PT", "Phu Tho", 50000);

//        insert
//        cityDAO.insert(city1);
//        cityDAO.insert(city2);
//        cityDAO.insert(city3);
//        cityDAO.insert(city4);
//        cityDAO.insert(city5);
//        cityDAO.insert(city6);

//        update
//        city1.setNameCity("Ha Noi");
//        cityDAO.update(city1);

//        delete
//        cityDAO.delete(city6);

//        getAll
//        for(City city : cityDAO.getAll()) {
//            System.out.println(city);
//        }

//        selectByID
//        System.out.println(cityDAO.selectById(city2));

//        selectByCondition
//        for(City city : cityDAO.selectByCondition("shippingFee = 40000")) {
//            System.out.println(city);
//        }

//        Customer customer1 = new Customer("K1", "Nguyen Thi Loan", new Date(2004-1900,7,27), false, city1, "0977342145", "Loanxinhiu@gmail.com");
//        customerDAO.insert(customer1);
//        Customer customer2 = new Customer("K2", "Nguyen Duy Loi", new Date(2024-1900, 4, 25), true, city1, "0872342134", "duyloi@gmail.com");
//        customerDAO.insert(customer2);
//        customer2.setNameCustomer("Nguyen Phi Hung");
//        customerDAO.update(customer2);

        String baoLoi = "";
        AccountDAO accountDAO = new AccountDAO();
        if(accountDAO.selectByCondition("username = '"+"loanxinhiu"+"'").size() != 0){
            System.out.println("tontai");
        }
    }
}
