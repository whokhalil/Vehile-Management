package com.mukul.vehicle.io.service;

import com.mukul.vehicle.io.model.State;
import com.mukul.vehicle.io.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    //Returns List Of States
    public List<State> getStates() {
        return stateRepository.findAll();
    }

    //Add new State
    public void save(State state) {
        stateRepository.save(state);
    }

    //Find state by Id
    public Optional<State> findById(Integer id) {
        return stateRepository.findById(id);
    }

    //Delete State
    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }
}
