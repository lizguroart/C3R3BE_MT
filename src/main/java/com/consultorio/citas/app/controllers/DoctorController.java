/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consultorio.citas.app.controllers;

import com.consultorio.citas.app.entities.Doctor;
import com.consultorio.citas.app.services.DoctorService;
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
@RequestMapping("Doctor")
@CrossOrigin(origins = "*")

public class DoctorController {
    
            @Autowired
    private DoctorService service;
    
    @GetMapping("/all")
    public List<Doctor> getDoctors(){
        return service.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus (HttpStatus.CREATED)
    public Doctor save (@RequestBody Doctor doctor)
    {
        return service.save(doctor);
    }
    
    
    @PutMapping("/update")
    @ResponseStatus (HttpStatus.CREATED)
    public Doctor update (@RequestBody Doctor doctor)
    {
        return service.update(doctor);
    }
     @DeleteMapping("/{id}")
     //@ResponseStatus (HttpStatus.CREATED)
       @ResponseStatus(HttpStatus.NO_CONTENT)

    public boolean delete(@PathVariable("id") int doctorId)
    {
        return service.delete(doctorId);
    }


}