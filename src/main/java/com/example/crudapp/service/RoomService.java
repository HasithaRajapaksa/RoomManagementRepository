package com.example.crudapp.service;

import com.example.crudapp.models.Room;
import com.example.crudapp.models.RoomModel;
import com.example.crudapp.models.UserModel;
import com.example.crudapp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    //with validations(if available then 200 OK and if not found 404 not found.
    public Optional<RoomModel> getRoomById(Integer id){

        Optional<RoomModel> roomModel = roomRepository.findById(id);

        if (roomModel.isPresent()) {
            return roomModel;
        } else {
            return null;
        }

    }

    //with validations
    public ResponseEntity<HttpStatus> remove(Integer id){

        try {
            roomRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //with validations
    public ResponseEntity<RoomModel> createRooms(RoomModel roomModel){
        try {
            RoomModel roomModel1 = roomRepository.save(roomModel);
            return new ResponseEntity<>(roomModel1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





}
