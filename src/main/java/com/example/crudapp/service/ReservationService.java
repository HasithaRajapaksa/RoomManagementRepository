package com.example.crudapp.service;

import com.example.crudapp.models.ReservationsBody;
import com.example.crudapp.models.ReservationsModel;
import com.example.crudapp.models.RoomModel;
import com.example.crudapp.models.UserModel;
import com.example.crudapp.repository.ReservationRepository;
import com.example.crudapp.repository.RoomRepository;
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

    @Autowired
    RoomService roomService;

    @Autowired
    UserService userService;

    RoomModel roomModel;
    UserModel userModel;


    public Optional<ReservationsModel> getReservationById(Integer id){
        return reservationRepository.findById(id);
    }

    public List<?> multipleReservationStats(String start, String end){return reservationRepository.multipleReservationStats(start, end);}

    public ReservationsModel addReservation(ReservationsBody reservationsBody){

        roomModel = roomService.getById(reservationsBody.getRoomId());

        userModel = userService.getUserById(reservationsBody.getUserId());

        ReservationsModel reservationsModel = new ReservationsModel(reservationsBody.getDate(),reservationsBody.getHours(),
                roomModel,userModel);

        return reservationRepository.save(reservationsModel);
    }
}
