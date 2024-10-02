package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    private String idRole;
    private String nameRole;

    public Role(){}

    public Role(String idRole, String nameRole) {
        this.idRole = idRole;
        this.nameRole = nameRole;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole='" + idRole + '\'' +
                ", nameRole='" + nameRole + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(idRole, role.idRole) && Objects.equals(nameRole, role.nameRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRole, nameRole);
    }
}
