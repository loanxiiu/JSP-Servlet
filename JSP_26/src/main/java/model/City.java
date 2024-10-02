package model;

public class City {
    private String idCity;
    private String nameCity;
    private double shippingFee;

    public City(){}

    public City(String idCity, String nameCity, double shippingFee) {
        this.idCity = idCity;
        this.nameCity = nameCity;
        this.shippingFee = shippingFee;
    }

    public String getIdCity() {
        return idCity;
    }

    public void setIdCity(String idCity) {
        this.idCity = idCity;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }
}
