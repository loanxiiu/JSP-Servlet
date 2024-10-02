package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Order")
public class Order {
    @Id
//    @GeneratedValue tự sinh giá trị
    @Column(name = "idOrder", nullable = false)
    private String idOrder;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCustomer", nullable = false)
    private Customer customer;

    @Column(name = "dateOrder")
    private Date dateOrder;
    @Column(name = "dateDelivery")
    private Date dateDelivery;
    @Column(name = "status")
    private String status;
    @Column(name = "payment")
    private String payment;
    @Column(name = "totalPrice")
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

    @Override
    public String toString() {
        return "Order{" +
                "idOrder='" + idOrder + '\'' +
                ", customer=" + customer +
                ", dateOrder=" + dateOrder +
                ", dateDelivery=" + dateDelivery +
                ", status='" + status + '\'' +
                ", payment='" + payment + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
