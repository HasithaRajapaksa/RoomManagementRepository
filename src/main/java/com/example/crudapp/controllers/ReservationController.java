package com.example.crudapp.controllers;

import com.example.crudapp.models.Inputs;
import com.example.crudapp.models.ReservationsBody;
import com.example.crudapp.models.ReservationsModel;
import com.example.crudapp.models.RoomModel;
import com.example.crudapp.results.Statistics;
import com.example.crudapp.results.Stats;
import com.example.crudapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/find/{id}")
    public Optional<ReservationsModel> getReservationById(@PathVariable Integer id){
        return reservationService.getReservationById(id);
    }

    //change to query parameters with HTTP GET
    //learn http status codes
    //hybernate queries -hql
    //transactions - levels
    @GetMapping("/multipleReservations")
    @ResponseBody
    public List<?> multipleReservationStats(@RequestParam(name = "start",required = false) String start, @RequestParam(name = "end",required = false) String end){

        return reservationService.multipleReservationStats(start,end);
    }


    @PostMapping("/add")
    public ResponseEntity<String> addReservations(@RequestBody ReservationsBody reservationsBody){


       reservationService.addReservation(reservationsBody);

       return new ResponseEntity<String>("Created Successfully", HttpStatus.CREATED);

    }


}
