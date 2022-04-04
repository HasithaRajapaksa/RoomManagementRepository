package com.example.crudapp.service;

import com.example.crudapp.models.ReservationsModel;
import com.example.crudapp.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public Optional<ReservationsModel> getReservationById(Integer id){
        return reservationRepository.findById(id);
    }
}
