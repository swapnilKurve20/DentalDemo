package com.sample.demo.DentalDemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "startTime")
    private Time startTime;
    @Column(name = "endTime")
    private Time endTime;
    @Column(name = "dateOfAppointment")
    private Date dateOfAppointment;
    @Column(name = "bookedForDrId")
    private Long bookedForDrID;
    @Column(name = "bookedByUserId")
    private Long bookedByUserId;
    @Column(name = "cancelledByUserId")
    private Long cancelledByUserId;
    @Column(name = "status")
    private String status;
    @Column(name = "createdAt")
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());


}
