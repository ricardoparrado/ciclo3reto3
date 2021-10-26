package com.usa.ciclo3.ciclo3.service;


import com.usa.ciclo3.ciclo3.model.Machine;
import com.usa.ciclo3.ciclo3.model.UAdministrator;
import com.usa.ciclo3.ciclo3.repository.UAdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UAdministratorService {

    @Autowired
    private UAdministratorRepository uAdministratorRepository;

    public List<UAdministrator> getAll() {
        return uAdministratorRepository.getAll();
    }

    public Optional<UAdministrator> getUAdministrator(int id) {
        return uAdministratorRepository.getUAministrator(id);
    }

    public UAdministrator save(UAdministrator uads) {
        if (uads.getIdadminuser() == null) {
            return uAdministratorRepository.save(uads);
        } else {
            Optional<UAdministrator> uAdministratorAuxiliar = uAdministratorRepository.getUAministrator(uads.getIdadminuser());
            if (uAdministratorAuxiliar.isEmpty()) {
                return uAdministratorRepository.save(uads);
            } else {
                return uads;
            }
        }
    }

    public UAdministrator update(UAdministrator uaup) {
        if (uaup.getIdadminuser() != null) {
            Optional<UAdministrator> uAdministratorAuxiliar = uAdministratorRepository.getUAministrator(uaup.getIdadminuser());
            if (uAdministratorAuxiliar.isPresent()) {
                if (uaup.getName() != null) {
                    uAdministratorAuxiliar.get().setName(uaup.getName());
                }
                if (uaup.getEmail() != null) {
                    uAdministratorAuxiliar.get().setEmail(uaup.getEmail());
                }
                if (uaup.getPassword() != null) {
                    uAdministratorAuxiliar.get().setPassword(uaup.getPassword());
                }
                return uAdministratorRepository.save(uAdministratorAuxiliar.get());
            }
        }
        return uaup;

    }

    public boolean deleteUAdministrator(int id) {
        Optional<UAdministrator> uAdministratorAuxiliar = getUAdministrator(id);
        if (uAdministratorAuxiliar.isPresent()) {
            uAdministratorRepository.delete(uAdministratorAuxiliar.get());
            return true;
        }
        return false;

    }

}
