package com.example.crudapp.models;


import javax.persistence.*;

@Entity
@Table(name = "Reservation")
public class ReservationsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "datein")
    private String date;

    @Column(name = "hours")
    private Integer hours;

    @ManyToOne
    @JoinColumn(name = "room_id")
    RoomModel roomModel;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserModel userModel;

    public ReservationsModel() {
    }

    public ReservationsModel(Integer id, String date, Integer hours, RoomModel roomModel, UserModel userModel) {
        this.id = id;
        this.date = date;
        this.hours = hours;
        this.roomModel = roomModel;
        this.userModel = userModel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public RoomModel getRoomModel() {
        return roomModel;
    }

    public void setRoomModel(RoomModel roomModel) {
        this.roomModel = roomModel;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
