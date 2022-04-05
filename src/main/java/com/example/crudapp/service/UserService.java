package com.example.crudapp.service;

import com.example.crudapp.models.ReservationsModel;
import com.example.crudapp.models.UserModel;
import com.example.crudapp.repository.RoomRepository;
import com.example.crudapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel getUserById(Integer id){
        return userRepository.getById(id);
    }
}
