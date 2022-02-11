/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.org.phyllis.robertson.home.entity;

import lombok.Data;
import za.org.phyllis.robertson.home.model.ResidenceType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author snuif
 */
@Data
@Entity
@Table(name = "RESIDENT")
public class Resident implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ID_NUMBER")
    private String idNumber;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NICK_NAME")
    private String nickname;

    @Column(name = "DATE_OF_BIRTH")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "AGE")
    private int age;

    @Column(name = "ROOM_NUMBER")
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "RESIDENCE_TYPE")
    private ResidenceType residenceType;

    @Column(name = "CONDITIONS")
    private String conditions;

    @Column(name = "MEDICAL_AID")
    private String medicalAid;

    @Column(name = "MEDICAL_AID_NUMBER")
    private String MedicalAidNumber;

    @Column(name = "PREFERRED_HOSPITAL")
    private String preferredHospital;

    @Column(name = "DOCTOR")
    private String doctor;

    @Column(name = "PARENT_GUARDIAN_NAME")
    private String contactDetails;

    @Column(name = "PARENT_GUARDIAN_NAME")
    private String ambulanceService;

    @Column(name = "PARENT_GUARDIAN_NAME")
    private String parentGuardianName;

    @Column(name = "PARENT_GUARDIAN_PHONE_NUMBER")
    private String parentGuardianPhoneNumber;

    @Column(name = "PARENT_GUARDIAN_EMAIL")
    private String parentGuardianEmail;

}
