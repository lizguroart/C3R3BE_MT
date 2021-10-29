/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consultorio.citas.app.services;

import com.consultorio.citas.app.entities.Specialty;
import com.consultorio.citas.app.repositorie.SpecialtyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lizguro
 */
@Service
public class SpecialtyService {
    
  @Autowired
    private SpecialtyRepository repository;
    
    //Consultar Todos los registros.
    public List<Specialty> getAll(){
        return repository.getAll();
    }
    
    //Buscar registro
    public Optional<Specialty> getSpecialty(int specialtyId) {
        return repository.getSpecialty(specialtyId);
    }
    
    //Registrar 
    public Specialty save(Specialty specialty){
        if(specialty.getId()==null){
            return repository.save(specialty);
        }else{
            Optional<Specialty> resultado = repository.getSpecialty(specialty.getId());
            if(resultado.isPresent()){
                return specialty;
            }else{
                return repository.save(specialty);
            }
        }
    }
    
    //Actualizar
    public Specialty update(Specialty specialty){
        if(specialty.getId()!=null){
            Optional<Specialty> resultado = repository.getSpecialty(specialty.getId());
            if(resultado.isPresent()){
                if(specialty.getName()!=null){
                    resultado.get().setName(specialty.getName());
                }
                
                if(specialty.getDescription()!=null){
                    resultado.get().setDescription(specialty.getDescription());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return specialty;
            }
        }else{
            return specialty;
        }
    }
    
    //Eliminar
    public boolean delete(int id){
        Boolean aBoolean = getSpecialty(id).map(specialty -> {
           repository.delete(specialty);
           return true;
        }).orElse(false);
        return aBoolean;
    } 
}