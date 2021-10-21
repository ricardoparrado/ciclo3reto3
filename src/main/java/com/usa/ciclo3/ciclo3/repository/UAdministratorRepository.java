package com.usa.ciclo3.ciclo3.repository;


import com.usa.ciclo3.ciclo3.model.UAdministrator;
import com.usa.ciclo3.ciclo3.repository.crud.UAdministratorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class UAdministratorRepository {

    @Autowired
    private UAdministratorCrudRepository uAdministratorCrudRepository;

    public List<UAdministrator> getAll() {
        return (List<UAdministrator>) uAdministratorCrudRepository.findAll();
    }

    public Optional<UAdministrator> getUAministrator(int id) {
        return uAdministratorCrudRepository.findById(id);
    }

    public UAdministrator save(UAdministrator uads) {
        return uAdministratorCrudRepository.save(uads);
    }
}
