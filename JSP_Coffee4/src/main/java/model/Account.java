package model;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @Column(name = "username")
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role role;
    public Account() {}

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(username, account.username) && Objects.equals(password, account.password) && Objects.equals(role, account.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, role);
    }
}
