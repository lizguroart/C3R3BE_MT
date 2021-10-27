/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consultorio.citas.app.repositorie;

import com.consultorio.citas.app.entities.Reservation;
import com.consultorio.citas.app.repositories.crud.ReservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lizguro
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository repository;
    
    /**
     * Consultar
     * @return 
    */
    
        public List<Reservation> getAll(){
        return (List<Reservation>) repository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Reservation> getReservation(int id){
        return repository.findById(id);
    }
    
    /**
     * Registrar
     */
    public Reservation save(Reservation reservation){
        return repository.save(reservation);
    }
    
    /**
     * Eliminar
     */
    public void delete(Reservation reservation){
        repository.delete(reservation);
    }
    

}


