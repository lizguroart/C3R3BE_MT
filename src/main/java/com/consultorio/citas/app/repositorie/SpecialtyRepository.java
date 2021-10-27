/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consultorio.citas.app.repositorie;

import com.consultorio.citas.app.entities.Client;
import com.consultorio.citas.app.entities.Specialty;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.consultorio.citas.app.repositories.crud.SpecialtyCrudRepository;

/**
 *
 * @author Lizguro
 */
@Repository
public class SpecialtyRepository {
    
    @Autowired
    private SpecialtyCrudRepository repository;
    
    /**
     * Consultar
     * @return 
    */
    
        public List<Specialty> getAll(){
        return (List<Specialty>) repository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Specialty> getSpecialty(int id){
        return repository.findById(id);
    }
    
    /**
     * Registrar
     */
    public Specialty save(Specialty specialty){
        return repository.save(specialty);
    }
    
    /**
     * Eliminar
     */
    public void delete(Specialty specialty){
        repository.delete(specialty);
    }
    

}