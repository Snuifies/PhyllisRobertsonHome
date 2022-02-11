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
@Table(name = "HOUSEKEEPING")
public class Housekeeping implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String Date;
    private String WashingRemoved;
    private String WashingReturned;
    private String WashingIssue;
    private String RoomCleaned;
    private String CleaningIssues;
    private String MonthlyDeepClean;
    private String FaultComplaint;
    private String FaultResolved;
}
