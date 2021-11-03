/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consultorio.citas.app.controllers;

import com.consultorio.citas.app.entities.CountClients;
import com.consultorio.citas.app.entities.Reservation;
import com.consultorio.citas.app.services.ReservationService;
import com.retoLibrary.Library.entities.CountScore;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lizguro
 */
@RestController
@RequestMapping("Reservation")
@CrossOrigin(origins = "*")


public class ReservationController {

                 @Autowired
    private ReservationService service;
    
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return service.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus (HttpStatus.CREATED)
    public Reservation save (@RequestBody Reservation reservation)
    {
        return service.save(reservation);
    }
    
    
    @PutMapping("/update")
    @ResponseStatus (HttpStatus.CREATED)
    public Reservation update (@RequestBody Reservation reservation)
    {
        return service.update(reservation);
    }
     @DeleteMapping("/{id}")
     //@ResponseStatus (HttpStatus.CREATED)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId)
    {
        return service.delete(reservationId);
    }
        
    @GetMapping("/report-status")
    public CountScore getReservationStatus()
    {
        return service.getStatusScore();
    }
        
    @GetMapping("/report-clients")
    public List<CountClients> gerReport()
    {
        return service.getTopByClient();
    }
}
