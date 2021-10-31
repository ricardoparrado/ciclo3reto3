package com.usa.ciclo3.ciclo3.repository;


import com.usa.ciclo3.ciclo3.model.Client;
import com.usa.ciclo3.ciclo3.model.Machine;
import com.usa.ciclo3.ciclo3.model.Reservation;
import com.usa.ciclo3.ciclo3.model.custom.CountClient;
import com.usa.ciclo3.ciclo3.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation rs) {
        return reservationCrudRepository.save(rs);
    }

    public void delete(Reservation rd) {
        reservationCrudRepository.delete(rd);
    }


    public List<Reservation> ReservationStatusRepository (String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> ReservationTimeRepository (Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);

    }

    public List<CountClient> getClientRepository(){
        List<CountClient> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }

}
