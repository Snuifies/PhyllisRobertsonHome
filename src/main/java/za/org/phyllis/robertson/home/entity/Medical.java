/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.org.phyllis.robertson.home.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author snuif
 */
@Data
@Entity
@Table(name = "MEDICAL")
public class Medical implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date DoctorVisitDate;
    private String DoctorAttended;
    private String AccompaniedBy;
    private String Treatment;
    private String Prescription;
    private String Dose;
    private Byte[] CopyOfPrescription;
    private Date NextAppointment;
    private Date MedicationToPharmacy;
    private String ItemSent;
    private int QuantitySent;
    private Date BlistersReceivedDate;
    private int BlistersReceived;
    private Boolean MedicineDueForRenewal;


}
