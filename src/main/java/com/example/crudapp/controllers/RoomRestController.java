package com.example.crudapp.controllers;

import com.example.crudapp.models.Room;
import com.example.crudapp.models.RoomModel;
import com.example.crudapp.service.RoomService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomRestController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/add")
    public RoomModel addRooms(@RequestBody RoomModel roomModel){
            return roomService.addRoom(roomModel);
    }

    @GetMapping("/getAllRooms")
    public Iterable<RoomModel> findAllRooms(){
            return roomService.findAll();
    }

    @GetMapping("/find/{id}")
    public RoomModel findById(@PathVariable Integer id){
            return roomService.findById(id);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeById(@PathVariable Integer id){
            RoomModel room = roomService.findById(id);
            roomService.remove(room);
            return new ResponseEntity<String>("Deleted", HttpStatus.OK);
    }
}
