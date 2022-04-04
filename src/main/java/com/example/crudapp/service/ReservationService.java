package com.example.crudapp.service;

import com.example.crudapp.models.ReservationsModel;
import com.example.crudapp.repository.ReservationRepository;
import com.example.crudapp.results.Statistics;
import com.example.crudapp.results.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public Optional<ReservationsModel> getReservationById(Integer id){
        return reservationRepository.findById(id);
    }

    public List<?> multipleReservationStats(String start, String end){return reservationRepository.multipleReservationStats(start, end);}

    public ReservationsModel addReservation(ReservationsModel reservationsModel){
        return reservationRepository.save(reservationsModel);
    }
}
