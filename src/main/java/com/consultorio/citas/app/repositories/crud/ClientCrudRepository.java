/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consultorio.citas.app.repositories.crud;

import com.consultorio.citas.app.entities.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Lizguro
 */
public interface ClientCrudRepository extends CrudRepository<Client, Integer> {

    
}