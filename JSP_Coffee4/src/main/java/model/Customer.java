package model;

import javax.persistence.*;
import java.sql.Date;
import java.time.Instant;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
//    @GeneratedValue
    @Column(name = "idCustomer", nullable = false)
    private String idCustomer;

    @Column(name = "nameCustomer")
    private String nameCustomer;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "gender")
    private boolean gender;

    @ManyToOne
    @JoinColumn(name = "idCity")
    private City address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", nullable = false)
    private Account account;

    @Column(name = "maXacThuc", length = 45)
    private String maXacThuc;

    @Column(name = "thoiGianHieuLucCuaMaXacThuc")
    private Instant thoiGianHieuLucCuaMaXacThuc;

    @Column(name = "trangThaiXacThuc")
    private Boolean trangThaiXacThuc;

    public Boolean getTrangThaiXacThuc() {
        return trangThaiXacThuc;
    }

    public void setTrangThaiXacThuc(Boolean trangThaiXacThuc) {
        this.trangThaiXacThuc = trangThaiXacThuc;
    }

    public Instant getThoiGianHieuLucCuaMaXacThuc() {
        return thoiGianHieuLucCuaMaXacThuc;
    }

    public void setThoiGianHieuLucCuaMaXacThuc(Instant thoiGianHieuLucCuaMaXacThuc) {
        this.thoiGianHieuLucCuaMaXacThuc = thoiGianHieuLucCuaMaXacThuc;
    }

    public String getMaXacThuc() {
        return maXacThuc;
    }

    public void setMaXacThuc(String maXacThuc) {
        this.maXacThuc = maXacThuc;
    }

    public Customer(String idCustomer, String nameCustomer, Date dateOfBirth, boolean gender, City address, String phoneNumber, String email, Account account, String maXacThuc, Instant thoiGianHieuLucCuaMaXacThuc, Boolean trangThaiXacThuc) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.account = account;
        this.maXacThuc = maXacThuc;
        this.thoiGianHieuLucCuaMaXacThuc = thoiGianHieuLucCuaMaXacThuc;
        this.trangThaiXacThuc = trangThaiXacThuc;
    }

    //    private boolean acceptEmail;
    public Customer() {}

    public Customer(String idCustomer, String nameCustomer, Date dateOfBirth, boolean gender, City address, String phoneNumber, String email, Account account) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.account = account;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public City getAddress() {
        return address;
    }

    public void setAddress(City address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer='" + idCustomer + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", address=" + address +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
