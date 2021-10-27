/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consultorio.citas.app.services;

import com.consultorio.citas.app.entities.Client;
import com.consultorio.citas.app.repositorie.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lizguro
 */
@Service
public class ClientService {
    
  @Autowired
    private ClientRepository repository;
    
    //Consultar Todos los registros.
    public List<Client> getAll(){
        return repository.getAll();
    }
    
    //Buscar registro
    public Optional<Client> getClient(int clientId) {
        return repository.getClient(clientId);
    }
    
    //Registrar 
    public Client save(Client client){
        if(client.getIdClient()==null){
            return repository.save(client);
        }else{
            Optional<Client> resultado = repository.getClient(client.getIdClient());
            if(resultado.isPresent()){
                return client;
            }else{
                return repository.save(client);
            }
        }
    }
    
    //Actualizar
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> resultado = repository.getClient(client.getIdClient());
            if(resultado.isPresent()){
                if(client.getName()!=null){
                    resultado.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    resultado.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    resultado.get().setPassword(client.getPassword());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    
    //Eliminar
    public boolean delete(int id){
        Boolean aBoolean = getClient(id).map(client -> {
           repository.delete(client);
           return true;
        }).orElse(false);
        return aBoolean;
    } 
}