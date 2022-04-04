package com.example.crudapp.repository;

import com.example.crudapp.models.ReservationsModel;
import com.example.crudapp.models.UserModel;
import com.example.crudapp.results.Statistics;
import com.example.crudapp.results.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<ReservationsModel,Integer> {

    Optional<ReservationsModel> findById(Integer id);

    @Query(value = "SELECT user.user_name AS username,count(reservation.id) AS numberOfRes \n" +
            "FROM user\n" +
            "LEFT JOIN reservation\n" +
            "ON user.id =reservation.user_id \n" +
            "where reservation.datein between :start AND :end \n" +
            "group by user.user_name ",nativeQuery = true)
    List<?> multipleReservationStats(@Param("start") String start, @Param("end") String end);
}
