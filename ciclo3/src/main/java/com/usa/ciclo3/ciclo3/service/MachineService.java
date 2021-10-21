package com.usa.ciclo3.ciclo3.service;


import com.usa.ciclo3.ciclo3.model.Machine;
import com.usa.ciclo3.ciclo3.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAll() {
        return machineRepository.getAll();
    }

    public Optional<Machine> getMachine(int id) {
        return machineRepository.getMachine(id);
    }

    public Machine save(Machine ms) {
        if (ms.getId() == null) {
            return machineRepository.save(ms);
        } else {
            Optional<Machine> machineAuxiliar = machineRepository.getMachine(ms.getId());
            if (machineAuxiliar.isEmpty()) {
                return machineRepository.save(ms);
            } else {
                return ms;
            }
        }
    }
}
