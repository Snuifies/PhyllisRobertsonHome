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
public class FoodServices implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

Allergies (10)
Diet type *
Dislikes (10)
Avoid (10)
Preference (3)
Complaint date
Complaint detail
Date planned absence
Meals absent
Packed lunch request
Kept lunch request
Bed meal request
Bed meal request
Food not eaten
Food not eaten

}
