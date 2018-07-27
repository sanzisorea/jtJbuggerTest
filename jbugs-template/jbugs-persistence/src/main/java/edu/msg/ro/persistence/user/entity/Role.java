package edu.msg.ro.persistence.user.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    @Column(nullable = false)
    private String type;

    @ManyToMany(mappedBy = "roleList")
    private List<User> userList;

    @ManyToMany
    @JoinTable(name = "Roles_Permissions", joinColumns = @JoinColumn(name = "idRole"),
            inverseJoinColumns = {@JoinColumn(name = "idPermission")})
    private List<Permission> permissionList;

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
