/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.retoLibrary.Library.entities;

import java.io.Serializable;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author blink
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "countscore")
public class CountScore implements Serializable{
    
    private int completed;
    private int cancelled;
    
}
