package com.usa.ciclo3.ciclo3.web;


import com.usa.ciclo3.ciclo3.model.Reservation;
import com.usa.ciclo3.ciclo3.model.custom.CountClient;
import com.usa.ciclo3.ciclo3.model.custom.StatusCount;
import com.usa.ciclo3.ciclo3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservations() {
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id) {
        return reservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation rs) {
        return reservationService.save(rs);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation rup){
        return reservationService.update(rup);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable("id") int id){
        return reservationService.deleteReservation(id);
    }

    //RETO 5

    @GetMapping("/report-status")
    public StatusCount getReservas(){
        return reservationService.reportStatusService();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo ){
        return reservationService.reportTimeService(dateOne, dateTwo);
    }

    @GetMapping("/report-clients")
    public List<CountClient> getClientes(){
        return reservationService.reportClientsService();
    }

}
