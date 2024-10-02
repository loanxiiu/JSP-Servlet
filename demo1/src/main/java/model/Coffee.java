package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CoffeeType")
public class Coffee {
    @Id
    @Column(name = "idCoffee", nullable = false)
    private String idCoffe;
    @Column(name = "nameCoffee", nullable = false)
    private String nameCoffe;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "detail")
    private String detail;
    public Coffee() {}

    public Coffee(String idCoffe, String nameCoffe, double price, int quantity, String detail) {
        this.idCoffe = idCoffe;
        this.nameCoffe = nameCoffe;
        this.price = price;
        this.quantity = quantity;
        this.detail = detail;
    }

    public String getIdCoffe() {
        return idCoffe;
    }

    public void setIdCoffe(String idCoffe) {
        this.idCoffe = idCoffe;
    }

    public String getNameCoffe() {
        return nameCoffe;
    }

    public void setNameCoffe(String nameCoffe) {
        this.nameCoffe = nameCoffe;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "idCoffe='" + idCoffe + '\'' +
                ", nameCoffe='" + nameCoffe + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", detail='" + detail + '\'' +
                '}';
    }
}
