package com.example.crudapp.repository;

import com.example.crudapp.models.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<RoomModel,Integer> {

    RoomModel getById(Integer id);

    //JPQL Query
    @Query("select r from RoomModel r where r.number= ?1 ")
    RoomModel getRoomModelBynumber(Integer no);

    //Native Query
    @Query(
            value = "select * from Rooms r where r.number = :number",
            nativeQuery = true
    )
    RoomModel getRoomModelBynum(@Param("number") Integer no);

}
