package com.project.user.activation.services;

import com.project.user.activation.persistence.entity.StateEntity;
import com.project.user.activation.persistence.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    private final StateRepository stateRepository;

    @Autowired
    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public List<StateEntity> getAll(){
        return this.stateRepository.findAll();
    }

    public StateEntity getById(Integer idState){
        return stateRepository.findById(idState).orElse(null);
    }

    public StateEntity addState(StateEntity state){
        return this.stateRepository.save(state);
    }

    public void deleteState(Integer idState){
        this.stateRepository.deleteById(idState);
    }

    public boolean stateExist(Integer idState){
        return this.stateRepository.existsById(idState);
    }
}
