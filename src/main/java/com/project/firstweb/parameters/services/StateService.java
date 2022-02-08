package com.project.firstweb.parameters.services;

import com.project.firstweb.parameters.models.State;
import com.project.firstweb.parameters.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> getAll(){
        return stateRepository.findAll();
    }

    public void save(State state){ stateRepository.save(state);}

    public void delete(Integer id) { stateRepository.deleteById(id);}

    public State findById(Integer id){ return stateRepository.findById(id).orElse(null);}

    public List<State> findAll() {
        return stateRepository.findAll();
    }
}
