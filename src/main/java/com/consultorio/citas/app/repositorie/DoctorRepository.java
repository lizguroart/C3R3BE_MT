/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consultorio.citas.app.repositorie;

import com.consultorio.citas.app.entities.Doctor;
import com.consultorio.citas.app.repositories.crud.DoctorCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lizguro
 */
@Repository
public class DoctorRepository {
    
    @Autowired
    private DoctorCrudRepository repository;
    
    /**
     * Consultar
     * @return 
    */
    
        public List<Doctor> getAll(){
        return (List<Doctor>) repository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Doctor> getDoctor(int id){
        return repository.findById(id);
    }
    
    /**
     * Registrar
     */
    public Doctor save(Doctor doctor){
        return repository.save(doctor);
    }
    
    /**
     * Eliminar
     */
    public void delete(Doctor doctor){
        repository.delete(doctor);
    }
    

}