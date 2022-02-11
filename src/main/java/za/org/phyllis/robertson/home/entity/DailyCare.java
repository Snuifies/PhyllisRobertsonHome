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
@Table(name = "DAILY_CARE")
public class DailyCare implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String Date;
    private String CareWorkerAssigned;
    private String Bath; ///shower/bedbath
    private String Shaved;
    private String NailsCut;
    private String HeelsTreated;
    private String BedMade;
    private String CleanLinnen;
    private String WashningRemoved;
    private String CupboardPacked;
    private String WheelchairCleaned;
    private String MedicationMorning;
    private String MedicationBreakfast;
    private String MedicationLunch;
    private String MedicationSupper;
    private String MedicationEvening;
    private String MedicationAcuteTime;
    private String MedicationAacuteItem;
    private String Complaint;
    private String ActionsAdvised;

}
