/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultorio.citas.app.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.consultorio.citas.app.entities.Client;
/**
 *
 * @author blink
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "countclients")
public class CountClients implements Serializable{
    
    
    private Long  total;  
    private Client client;
    
    
}
