package edu.msg.ro.persistence.user.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermission;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String description;

    @ManyToMany(mappedBy = "permissionList")
    private List<Role> roleList;

    public Long getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(Long idPermission) {
        this.idPermission = idPermission;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
