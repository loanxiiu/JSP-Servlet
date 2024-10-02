package model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Staff")
public class Staff {
    @Id
    private String idStaff;
    private String nameStaff;
    private Date dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "idCity")
    private City city;
    private boolean gender;
    private String phoneNumber;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", nullable = false)
    private Account account;
    public Staff() {}

    public Staff(String idStaff, String nameStaff, Date dateOfBirth, City city, boolean gender, String phoneNumber, String email, Account account) {
        this.idStaff = idStaff;
        this.nameStaff = nameStaff;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.account = account;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
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
        return "Staff{" +
                "idStaff='" + idStaff + '\'' +
                ", nameStaff='" + nameStaff + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", city=" + city +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", account=" + account +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return gender == staff.gender && Objects.equals(idStaff, staff.idStaff) && Objects.equals(nameStaff, staff.nameStaff) && Objects.equals(dateOfBirth, staff.dateOfBirth) && Objects.equals(city, staff.city) && Objects.equals(phoneNumber, staff.phoneNumber) && Objects.equals(email, staff.email) && Objects.equals(account, staff.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStaff, nameStaff, dateOfBirth, city, gender, phoneNumber, email, account);
    }
}
