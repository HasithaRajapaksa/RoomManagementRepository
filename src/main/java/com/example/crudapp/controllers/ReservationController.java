package com.example.crudapp.controllers;

import com.example.crudapp.models.Inputs;
import com.example.crudapp.models.ReservationsModel;
import com.example.crudapp.results.Statistics;
import com.example.crudapp.results.Stats;
import com.example.crudapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/multipleReservations")
    public List<?> multipleReservationStats(@RequestBody Inputs inputs){
        return reservationService.multipleReservationStats(inputs.startDate,inputs.endDate);
    }





}
