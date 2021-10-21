package com.usa.ciclo3.ciclo3.repository.crud;

import com.usa.ciclo3.ciclo3.model.Machine;
import org.springframework.data.repository.CrudRepository;

/**
 * MachineCrudRepository hereda de CrudRepository
 */

public interface MachineCrudRepository extends CrudRepository<Machine, Integer> {
}
