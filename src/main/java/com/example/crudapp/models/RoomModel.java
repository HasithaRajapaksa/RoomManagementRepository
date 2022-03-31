package com.example.crudapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Rooms")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class RoomModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "name")
    private String name;

    @Column(name = "information")
    private String info;

    @OneToMany(mappedBy = "roomModel")
    Set<ReservationsModel> reservations;

    public RoomModel() {
    }

    public RoomModel(Integer id, Integer number, String name, String info) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
