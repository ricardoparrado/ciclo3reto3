package com.usa.ciclo3.ciclo3.service;


import com.usa.ciclo3.ciclo3.model.Reservation;
import com.usa.ciclo3.ciclo3.model.custom.CountClient;
import com.usa.ciclo3.ciclo3.model.custom.StatusCount;
import com.usa.ciclo3.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation rs) {
        if (rs.getIdReservation() == null) {
            return reservationRepository.save(rs);
        } else {
            Optional<Reservation> reservationAuxiliar = reservationRepository.getReservation(rs.getIdReservation());
            if (reservationAuxiliar.isEmpty()) {
                return reservationRepository.save(rs);
            } else {
                return rs;
            }
        }
    }

    public Reservation update(Reservation rup) {
        if (rup.getIdReservation() != null) {
            Optional<Reservation> reservationAuxiliar = reservationRepository.getReservation(rup.getIdReservation());
            if (reservationAuxiliar.isPresent()) {
                if (rup.getStartDate() != null) {
                    reservationAuxiliar.get().setStartDate(rup.getStartDate());
                }
                if (rup.getDevolutionDate() != null) {
                    reservationAuxiliar.get().setDevolutionDate(rup.getDevolutionDate());
                }
                if (rup.getStatus() != null) {
                    reservationAuxiliar.get().setStatus(rup.getStatus());
                }
                return reservationRepository.save(reservationAuxiliar.get());
            }
        }
        return rup;

    }

    public boolean deleteReservation(int id) {
        Optional<Reservation> reservationAuxiliar = getReservation(id);
        if (reservationAuxiliar.isPresent()) {
            reservationRepository.delete(reservationAuxiliar.get());
            return true;
        }
        return false;

    }

    public StatusCount reportStatusService (){
        List<Reservation>completed= reservationRepository.ReservationStatusRepository("completed");
        List<Reservation>cancelled= reservationRepository.ReservationStatusRepository("cancelled");

        return new StatusCount(completed.size(), cancelled.size() );
    }
    public List<Reservation> reportTimeService (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");

        Date datoUno = new Date();
        Date datoDos = new Date();

        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return reservationRepository.ReservationTimeRepository(datoUno, datoDos);
        }else{
            return new ArrayList<>();

        }
    }
    public List<CountClient> reportClientsService(){
        return reservationRepository.getClientRepository();
    }

}
