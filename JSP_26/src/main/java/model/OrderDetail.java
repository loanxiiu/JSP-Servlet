package model;

public class OrderDetail {
    private String idOrderDetail;
    private Order order;
    private Coffee coffee;
    private int quantity;
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
}
