/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consultorio.citas.app.services;

import com.consultorio.citas.app.entities.Doctor;
import com.consultorio.citas.app.repositorie.DoctorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lizguro
 */
@Service
public class DoctorService {
    
  @Autowired
    private DoctorRepository repository;
    
    //Consultar Todos los registros.
    public List<Doctor> getAll(){
        return repository.getAll();
    }
    
    //Buscar registro
    public Optional<Doctor> getDoctor(int doctorId) {
        return repository.getDoctor(doctorId);
    }
    
    //Registrar 
    public Doctor save(Doctor doctor){
        if(doctor.getId()==null){
            return repository.save(doctor);
        }else{
            Optional<Doctor> resultado = repository.getDoctor(doctor.getId());
            if(resultado.isPresent()){
                return doctor;
            }else{
                return repository.save(doctor);
            }
        }
    }
    
    //Actualizar
    public Doctor update(Doctor doctor){
        if(doctor.getId()!=null){
            Optional<Doctor> resultado = repository.getDoctor(doctor.getId());
            if(resultado.isPresent()){
                if(doctor.getName()!=null){
                    resultado.get().setName(doctor.getName());
                }
                if(doctor.getDepartment()!=null){
                    resultado.get().setDepartment(doctor.getDepartment());
                }
                if(doctor.getDescription()!=null){
                    resultado.get().setDescription(doctor.getDescription());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return doctor;
            }
        }else{
            return doctor;
        }
    }
    
    //Eliminar
    public boolean delete(int id){
        Boolean aBoolean = getDoctor(id).map(doctor -> {
           repository.delete(doctor);
           return true;
        }).orElse(false);
        return aBoolean;
    } 
}