/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consultorio.citas.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Lizguro
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "message")
public class Message implements Serializable{
    
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    @Column (length = 250)
    private String messageText;
    
    
       @ManyToOne     
       @JoinColumn(name="id")     
       @JsonIgnoreProperties({"messages","reservations"})     
       private Doctor doctor;          
        
       @ManyToOne     
       @JoinColumn(name="idClient")     
       @JsonIgnoreProperties({"messages","reservations"})     
       private Client client; 
    
}
