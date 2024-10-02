package model;

import javax.persistence.*;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
    @Id
    @Column(name = "idOrderDetail", nullable = false)
    private String idOrderDetail;
    @ManyToOne
    @JoinColumn(name = "idOrder", nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "idCoffee", nullable = false)
    private Coffee coffee;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "vat")
    private double vat;

    public OrderDetail() {}

    public OrderDetail(String idOrderDetail, Order order, Coffee coffee, int quantity, double vat) {
        this.idOrderDetail = idOrderDetail;
        this.order = order;
        this.coffee = coffee;
        this.quantity = quantity;
        this.vat = vat;
    }

    public String getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(String idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "idOrderDetail='" + idOrderDetail + '\'' +
                ", order=" + order +
                ", coffee=" + coffee +
                ", quantity=" + quantity +
                ", vat=" + vat +
                '}';
    }
}
