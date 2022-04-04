package com.example.crudapp.repository;

import com.example.crudapp.models.ReservationsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<ReservationsModel,Integer> {

    Optional<ReservationsModel> findById(Integer id);
}
