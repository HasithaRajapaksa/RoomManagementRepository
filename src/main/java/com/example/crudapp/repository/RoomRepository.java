package com.example.crudapp.repository;

import com.example.crudapp.models.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<RoomModel,Integer> {

    RoomModel getById(Integer id);

}
