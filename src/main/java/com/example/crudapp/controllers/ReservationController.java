package com.example.crudapp.controllers;

import com.example.crudapp.models.ReservationsModel;
import com.example.crudapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
