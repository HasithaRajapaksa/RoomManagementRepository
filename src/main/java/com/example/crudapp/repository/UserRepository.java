package com.example.crudapp.repository;

import com.example.crudapp.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel,Integer> {

    UserModel getById(Integer id);
}
