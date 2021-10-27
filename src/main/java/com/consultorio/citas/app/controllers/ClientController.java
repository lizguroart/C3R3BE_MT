/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consultorio.citas.app.controllers;

import com.consultorio.citas.app.entities.Client;
import com.consultorio.citas.app.services.ClientService;
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
@RequestMapping("Client")
@CrossOrigin(origins = "*")

public class ClientController {
    
            @Autowired
    private ClientService service;
    
    @GetMapping("/all")
    public List<Client> getClients(){
        return service.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus (HttpStatus.CREATED)
    public Client save (@RequestBody Client client)
    {
        return service.save(client);
    }
    
    
    @PutMapping("/update")
    @ResponseStatus (HttpStatus.CREATED)
    public Client update (@RequestBody Client client)
    {
        return service.update(client);
    }
     @DeleteMapping("/{id}")
     //@ResponseStatus (HttpStatus.CREATED)
       @ResponseStatus(HttpStatus.NO_CONTENT)

    public boolean delete(@PathVariable("id") int clientId)
    {
        return service.delete(clientId);
    }


}