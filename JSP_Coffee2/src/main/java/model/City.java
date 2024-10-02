package model;

import javax.persistence.*;

@Entity
@Table(name = "City")
public class City {
    @Id
    @Column(name = "idCity", nullable = false)
    private String idCity;
    @Column(name = "nameCity", nullable = false)
    private String nameCity;
    @Column(name = "shippingFee")
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

    @Override
    public String toString() {
        return "City{" +
                "idCity='" + idCity + '\'' +
                ", nameCity='" + nameCity + '\'' +
                ", shippingFee=" + shippingFee +
                '}';
    }
}
