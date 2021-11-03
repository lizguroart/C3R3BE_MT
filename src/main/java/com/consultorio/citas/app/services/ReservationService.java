/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consultorio.citas.app.services;

import com.consultorio.citas.app.entities.CountClients;
import com.consultorio.citas.app.entities.Reservation;
import com.consultorio.citas.app.repositorie.ReservationRepository;
import com.retoLibrary.Library.entities.CountScore;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lizguro
 */
@Service
public class ReservationService {
    
  @Autowired
    private ReservationRepository repository;
    
    //Consultar Todos los registros.
    public List<Reservation> getAll(){
        return repository.getAll();
    }
    
    //Buscar registro
    public Optional<Reservation> getReservation(int reservationId) {
        return repository.getReservation(reservationId);
    }
    
    //Registrar 
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return repository.save(reservation);
        }else{
            Optional<Reservation> resultado = repository.getReservation(reservation.getIdReservation());
            if(resultado.isPresent()){
                return reservation;
            }else{
                return repository.save(reservation);
            }
        }
    }
    
    //Actualizar
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> resultado = repository.getReservation(reservation.getIdReservation());
            if(resultado.isPresent()){
                if(reservation.getStartDate()!=null){
                    resultado.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    resultado.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    resultado.get().setStatus(reservation.getStatus());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    
    //Eliminar
    public boolean delete(int id){
        Boolean aBoolean = getReservation(id).map(reservation -> {
           repository.delete(reservation);
           return true;
        }).orElse(false);
        return aBoolean;
    } 
    public List<Reservation> getReservationsPeriod(String dateA, String dateB)
    {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat parser = new SimpleDateFormat(pattern);
        Date a = new Date();
        Date b = new Date();
    try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        }
    catch (ParseException e)
        {
            e.printStackTrace();
        }
    if(a.before(b))
        {
            return repository.getReservationPeriod(a, b);
        }
    else
       {
         return new ArrayList<>();
       }

    }
    
    public CountScore getStatusScore() 
    {
        List<Reservation> completed= repository.getLibraryByStatus("completed");
        List<Reservation> cancelled= repository.getLibraryByStatus("cancelled");
        
        CountScore coSco = new CountScore(completed.size(),cancelled.size());
        return coSco;
    } 
    
    //Ordenar Clientes
    public List<CountClients> getTopByClient()
     {
        return repository.getToClientByClient();
     }

}
