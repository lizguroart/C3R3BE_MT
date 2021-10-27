/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consultorio.citas.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table (name = "specialty")
public class Specialty implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (length = 45)
    private String name;
    @Column (length = 250)
    private String description;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy ="specialty")
    @JsonIgnoreProperties ("specialty")
    private List<Doctor> doctors;

    
}