package com.usa.ciclo3.ciclo3.service;


import com.usa.ciclo3.ciclo3.model.Client;
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

    public Machine update(Machine mup) {
        if (mup.getId() != null) {
            Optional<Machine> machineAuxiliar = machineRepository.getMachine(mup.getId());
            if (machineAuxiliar.isPresent()) {
                if (mup.getName() != null) {
                    machineAuxiliar.get().setName(mup.getName());
                }
                if (mup.getBrand() != null) {
                    machineAuxiliar.get().setBrand(mup.getBrand());
                }
                if (mup.getYear() != null) {
                    machineAuxiliar.get().setYear(mup.getYear());
                }

                if (mup.getDescription() != null) {
                    machineAuxiliar.get().setDescription(mup.getDescription());
                }
                return machineRepository.save(machineAuxiliar.get());
            }
        }
        return mup;

    }

    public boolean deleteMachine(int id) {
        Optional<Machine> machineAuxiliar = getMachine(id);
        if (machineAuxiliar.isPresent()) {
            machineRepository.delete(machineAuxiliar.get());
            return true;
        }
        return false;

    }
}
