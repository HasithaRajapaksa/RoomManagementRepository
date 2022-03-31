package com.example.crudapp.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "User")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "userName")
    private String userName;

    @OneToMany(mappedBy = "userModel")
    Set<ReservationsModel> reservations;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
