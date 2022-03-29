package com.example.crudapp.repository;

import com.example.crudapp.models.RoomModel;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<RoomModel,Integer> {

    RoomModel getById(Integer id);

}
