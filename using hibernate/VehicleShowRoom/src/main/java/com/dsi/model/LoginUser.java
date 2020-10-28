package com.dsi.model;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_owner_name_table")
public class LoginUser {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
    @Column(name = "owner")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userName;
    }
}
