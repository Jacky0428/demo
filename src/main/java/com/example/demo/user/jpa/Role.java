package com.example.demo.user.jpa;

import javax.persistence.*;
import java.util.Set;

/**
 * 角色
 */
@Entity
public class Role {

    @Id
    private String roleId;

    private String roleName;

    @ManyToMany
    @JoinTable(name = "role_permissions",
            joinColumns = {@JoinColumn(referencedColumnName = "roleId")})
    private Set<Permission> permissions;

    @ManyToMany
    @JoinTable(name = "role_user",
            joinColumns = {@JoinColumn(referencedColumnName = "roleId")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "account", name = "userAccount")})
    private Set<User> users;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
