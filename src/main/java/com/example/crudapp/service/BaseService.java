package com.example.crudapp.service;

import com.example.crudapp.models.Room;
import com.example.crudapp.models.RoomModel;

import java.util.List;

public interface BaseService {

    public default RoomModel addRoom(RoomModel roomModel) {
        return null;
    }

    public default Iterable<RoomModel> findAll(){
        return null;
    }

    public default RoomModel findById(Integer id) {
        return null;
    }

    public default void remove(RoomModel roomModel) {}



}
