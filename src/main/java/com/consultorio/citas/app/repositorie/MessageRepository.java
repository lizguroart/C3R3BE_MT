/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consultorio.citas.app.repositorie;

import com.consultorio.citas.app.entities.Message;
import com.consultorio.citas.app.repositories.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lizguro
 */

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository repository;
    
    /**
     * Consultar
     * @return 
    */
    
        public List<Message> getAll(){
        return (List<Message>) repository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Message> getMessage(int id){
        return repository.findById(id);
    }
    
    /**
     * Registrar
     */
    public Message save(Message message){
        return repository.save(message);
    }
    
    /**
     * Eliminar
     */
    public void delete(Message message){
        repository.delete(message);
    }
    

}

