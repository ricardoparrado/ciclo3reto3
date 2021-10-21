package com.usa.ciclo3.ciclo3.repository.crud;


import com.usa.ciclo3.ciclo3.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * CategoryCrudRepository hereda de CrudRepository
 */

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
