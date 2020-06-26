package com.devincubator.project.hibernate.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    @Column
    private String nameRole;

    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    private List<User> users;

    public Role() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(roleId, role.roleId) &&
                Objects.equals(nameRole, role.nameRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, nameRole);
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", nameRole='" + nameRole + '\'' +
                '}';
    }
}
