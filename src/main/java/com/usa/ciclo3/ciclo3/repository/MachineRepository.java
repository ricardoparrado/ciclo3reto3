package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.model.Machine;
import com.usa.ciclo3.ciclo3.repository.crud.MachineCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
  MachineRepository hace uso de CrudRepository
 */

/*
 * @Repository: Es el package que contiene las interfaces que extienden de JPA
 * para que estas clases se conecten a la base de datos. Estas gestionan información
 * ya sea de buscar, borrar, actualizar o crear un registro en la base de datos.
 */

@Repository
public class MachineRepository {

    /*
     * Spring @Autowired es una de las anotaciones más habituales cuando trabajamos
     * con Spring Framework ya que se trata de la anotación que permite inyectar unas
     * dependencias con otras dentro de Spring .
     */
    @Autowired
    private MachineCrudRepository machineCrudRepository;

    /*
     * ********************  METODOS GET DE MACHINE  ********************
     * <p>
     * Metodo que consulta en la BD todos los elementos de la tabla "Machine" y
     * los entrega como una lista.
     */
    public List<Machine> getAll() {
        return (List<Machine>) machineCrudRepository.findAll();
    }

    /*
     * Un Optional es una clase que puede o no contener un valor, es decir,
     * que se comporta como un wrapper para cualquier tipo de objeto que pueda o no ser nulo.
     */
    public Optional<Machine> getMachine(int id) {
        return machineCrudRepository.findById(id);
    }

    /*
     * ********************  METODO SAVE DE MACHINE (ms) ********************
     */
    public Machine save(Machine ms) {
        return machineCrudRepository.save(ms);
    }

    /*
     * ********************  METODO DELETE DE MACHINE (md) ********************
     */
    public void delete(Machine md) {
        machineCrudRepository.delete(md);
    }

}
