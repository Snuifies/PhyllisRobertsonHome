/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.org.phyllis.robertson.home.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author snuif
 */
@Data
@Entity
@Table(name = "FOOD_SERVICES")
public class FoodServices implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Allergies;
    private String DietType;
    private String Dislikes;
    private String Avoid;
    private String Preference;
    private String ComplaintDate;
    private String ComplaintDetail;
    private String DatePlannedAbsence;
    private String MealsAbsent;
    private String PackedLunchRequest;
    private String KeptLunchRequest;
    private String BedMealRequest;
    private String FoodNotEaten;

}
