package com.example.crudapp.models;

public class ReservationsBody {

    private Integer userId;

    private Integer roomId;

    private String date;

    private Integer hours;

    public ReservationsBody(Integer userId, Integer roomId, String date, Integer hours) {
        this.userId = userId;
        this.roomId = roomId;
        this.date = date;
        this.hours = hours;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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
}
