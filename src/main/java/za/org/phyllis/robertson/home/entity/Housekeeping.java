/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.org.phyllis.robertson.home.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author snuif
 */
@Data
@Entity
@Table(name = "RESIDENT")
public class Housekeeping implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
Date
Washing removed
Washing removed
Washing returned
Washing returned
Washing issue
Washing issue
Room cleaned
Room cleaned
Cleaning issues
Monthly deep clean
Monthly deep clean
Fault complaint
Fault complaint
Fault resolved
Fault resolved

}
