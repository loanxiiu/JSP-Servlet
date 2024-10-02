package model;

public class Coffee {
    private String idCoffe;
    private String nameCoffe;
    private double price;
    private int quantity;
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
}
