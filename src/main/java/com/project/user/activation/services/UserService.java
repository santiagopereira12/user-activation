package com.project.user.activation.services;

import com.project.user.activation.persistence.entity.UserEntity;
import com.project.user.activation.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAll(){
        return this.userRepository.findAll();
    }

}
