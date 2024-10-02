package model;

import java.sql.Date;

public class Order {
    private String idOrder;
    private Customer customer;
    private Date dateOrder;
    private Date dateDelivery;
    private String status;
    private String payment;
    private double totalPrice;

    public Order() {}

    public Order(String idOrder, Customer customer, Date dateOrder, Date dateDelivery, String status, String payment, double totalPrice) {
        this.idOrder = idOrder;
        this.customer = customer;
        this.dateOrder = dateOrder;
        this.dateDelivery = dateDelivery;
        this.status = status;
        this.payment = payment;
        this.totalPrice = totalPrice;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
