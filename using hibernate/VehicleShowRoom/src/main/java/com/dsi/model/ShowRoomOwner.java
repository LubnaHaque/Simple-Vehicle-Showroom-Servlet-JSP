package com.dsi.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class ShowRoomOwner {

    @Column(name = "show_room_id" , unique = true , nullable = false)
    private String showRoomId;
    @Column(name = "full_name" , nullable = false)
    private String fullName;
    @Id
    @Column(name = "user_name" , unique = true , nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;


    public String getShowRoomId() {
        return showRoomId;
    }

    public void setShowRoomId(String showRoomId) {
        this.showRoomId = showRoomId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ShowRoomOwner{" +
                "showRoomId='" + showRoomId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
