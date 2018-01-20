package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
 
@Entity
@Table(name = "User_Roles", uniqueConstraints = //
           @UniqueConstraint(columnNames = { "Username", "User_Role" }))
public class UserRole {
 
    private int roleId;
    private User user;
    private String userRole;

	@Id
    @Column(name = "Role_Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getRoleId() {
        return roleId;
    }
 
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Username")
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
 
    @Column(name = "User_Role", length = 30, nullable = false)
    public String getUserRole() {
        return userRole;
    }
 
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
 
}