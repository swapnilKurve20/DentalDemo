package com.sample.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(
    name = "appointment",
    indexes = {
      @Index(name = "bookedByUserIdIndx", columnList = "bookedByUserId"),
      @Index(name = "bookedForDrIDIndx", columnList = "bookedForDrID")
    })
@EntityListeners(AuditingEntityListener.class)
public class Appointment {
  @Id @GeneratedValue private Long id;

  @Column(name = "startTime")
  private Date startTime;

  @Column(name = "endTime")
  private Date endTime;

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

  @CreatedDate
  @Column(name = "createdAt")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date createdAt;

  @LastModifiedDate
  @Column(name = "updatedAt")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date updatedAt;
}
