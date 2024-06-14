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

    public UserEntity getById(Integer idUser){
        return this.userRepository.findById(idUser).orElse(null);
    }

    public UserEntity saveUser(UserEntity user){
        return this.userRepository.save(user);
    }

    public void deleteUser(Integer idUser){
        this.userRepository.deleteById(idUser);
    }

    public boolean userExist(Integer idUser){
        return this.userRepository.existsById(idUser);
    }

}
