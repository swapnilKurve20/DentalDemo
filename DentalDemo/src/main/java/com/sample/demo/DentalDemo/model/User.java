package com.sample.demo.DentalDemo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    @Column(name = "userId")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "userType")
    private String userType;

    private void setUserType(String value){
        if(value.equals(UserType.Doctor.name())){
           this.userType = UserType.Doctor.name();
        }else if(value.equals(UserType.Patient.name())){
           this.userType = UserType.Patient.name();
        }
    }

}
