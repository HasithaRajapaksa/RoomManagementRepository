package com.example.crudapp.service;

import com.example.crudapp.models.Room;
import com.example.crudapp.models.RoomModel;
import com.example.crudapp.models.UserModel;
import com.example.crudapp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements BaseService{

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public RoomModel addRoom(RoomModel roomModel) {
        return roomRepository.save(roomModel);
    }

    @Override
    public Iterable<RoomModel> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public RoomModel getById(Integer id) {
        return roomRepository.getById(id);
    }

    @Override
    public void remove(RoomModel roomModel) {
        roomRepository.delete(roomModel);
    }

    //JPQL
    public RoomModel getRoomModelBynumber(Integer no){
        return roomRepository.getRoomModelBynumber(no);
    }

    //Native
    public RoomModel getRoomModelNum(Integer no){
        return roomRepository.getRoomModelBynum(no);
    }




}
