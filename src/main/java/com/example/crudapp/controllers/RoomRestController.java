package com.example.crudapp.controllers;

import com.example.crudapp.models.Inputs;
import com.example.crudapp.models.Room;
import com.example.crudapp.models.RoomModel;
import com.example.crudapp.models.UserModel;
import com.example.crudapp.service.RoomService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomRestController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/add")
    public ResponseEntity<?> addRooms(@RequestBody RoomModel roomModel){
            roomService.addRoom(roomModel);
            return new ResponseEntity<String>("Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getAllRooms")
    public Iterable<RoomModel> findAllRooms(){
            return roomService.findAll();
    }

    @GetMapping("/find/{id}")
    public RoomModel getById(@PathVariable Integer id){
            return roomService.getById(id);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeById(@PathVariable Integer id){
            RoomModel room = roomService.getById(id);
            roomService.remove(room);
            return new ResponseEntity<String>("Deleted", HttpStatus.OK);
    }

    //JPQL
    @GetMapping("/findBynumber/{no}")
    public RoomModel findByNumber(@PathVariable Integer no){
        return roomService.getRoomModelBynumber(no);
    }

    //Native
    @GetMapping("/findBynum/{no}")
    public RoomModel findByNum(@PathVariable Integer no){
        return roomService.getRoomModelNum(no);
    }


    @GetMapping("/getRooms/{id}")
    public Optional<RoomModel> getRoomById(@PathVariable Integer id){

            return roomService.getRoomById(id);
    }

    //with validations
    @DeleteMapping("/removeRooms/{id}")
    public ResponseEntity<HttpStatus> remove(@PathVariable Integer id){

            return roomService.remove(id);

    }

    //with validations
    @PostMapping("/addRooms")
    public ResponseEntity<RoomModel> createRooms(@RequestBody RoomModel roomModel){

            return roomService.createRooms(roomModel);
    }





}
